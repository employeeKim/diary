package com.site.diary.domain.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.diary.SMS.SmsService;
import com.site.diary.domain.dto.MemberEntity;
import com.site.diary.domain.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private SmsService smsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    /**
     * 회원가입 
     */
    @PostMapping("/join")
    @ResponseBody
    public Map<String, Object> join(@RequestBody MemberEntity params) {
    	params.setPw(passwordEncoder.encode(params.getPw()));
        return memberService.join(params);
    }
    
    /**
     * 로그인 세션 확인 
     */
    @GetMapping("/checkLogin")
    @ResponseBody
    public Map<String, Object> checkLogin(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("loginUser") != null) {
            MemberEntity member = (MemberEntity) session.getAttribute("loginUser");
            result.put("status", "success");
            result.put("memberId", member.getMemberId());
            result.put("name", member.getName());
        } else {
            result.put("status", "fail");
        }

        return result;
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody MemberEntity params, HttpServletRequest request) {
        return memberService.login(params, request);
    }
    
    /**
     * 로그아웃 
     */
    @PostMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request) {
    	// 기존 세션이 있는 경우만 세션을 제거하기 위함 ( 기존 세션이 없으면 null을 반환함 )
        HttpSession session = request.getSession(false);
        
        if (session != null) {
        	//세션 삭제
            session.invalidate();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("message", "로그아웃 성공");

        return result;
    }
    
    /**
     * 아이디 중복체크 
     */
    @GetMapping("/isMemberIdCheck")
    @ResponseBody
    public Map<String, Object> isMemberIdCheck(@RequestParam String memberId) {
        Map<String, Object> result = new HashMap<>();
        log.info("memberId : :  : :  {} ", memberId);
        boolean isDuplicate = memberService.isMemberIdCheck(memberId);

        if (isDuplicate) {
            result.put("status", "fail");
            result.put("message", "이미 사용 중인 아이디입니다.");
        } else {
            result.put("status", "success");
            result.put("message", "사용 가능한 아이디입니다.");
        }
    	return result;
    }
    
    /**
     *  인증번호 보내기
     */
    @PostMapping("/sendVerification")
    @ResponseBody
    public Map<String, Object> sendVerification(@RequestBody Map<String, String> params, HttpServletRequest request) {
        String phone = params.get("phone");
        String verificationCode = generateVerificationCode(); // 인증번호 생성

        HttpSession session = request.getSession();
        session.setAttribute(phone, verificationCode);

        boolean isSent = smsService.sendSms(phone, "인증번호: " + verificationCode);

        Map<String, Object> response = new HashMap<>();
        if (isSent) {
            response.put("status", "success");
        } else {
            response.put("status", "fail");
        }
        return response;
    }

    // 인증번호 생성 로직
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 숫자
        return String.valueOf(code);
    }
    
    /**
     * 인증번호
     */
    @PostMapping("/verifyCode")
    @ResponseBody
    public Map<String, Object> verifyCode(@RequestBody Map<String, String> requestData, HttpServletRequest request) {
        String phone = requestData.get("phone");
        String inputCode = requestData.get("code");

        // 세션에서 인증번호 가져오기
        HttpSession session = request.getSession();
        String storedCode = (String) session.getAttribute(phone);

        Map<String, Object> response = new HashMap<>();
        if (storedCode != null && storedCode.equals(inputCode)) {
            response.put("status", "success");
            session.removeAttribute(phone); // 인증 완료 후 인증번호 삭제
        } else {
            response.put("status", "fail");
        }
        return response;
    }

}
