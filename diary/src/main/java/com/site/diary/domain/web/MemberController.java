package com.site.diary.domain.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.diary.domain.dto.MemberEntity;
import com.site.diary.domain.service.LogService;
import com.site.diary.domain.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    @PostMapping("/join")
    @ResponseBody
    public Map<String, Object> join(@RequestBody MemberEntity params) {
    	params.setPw(passwordEncoder.encode(params.getPw()));
        return memberService.join(params);
    }
    
    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody MemberEntity params) {
    	params.setPw(passwordEncoder.encode(params.getPw()));
        return memberService.login(params);
    }
    
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
}
