package com.site.diary.domain.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.site.diary.domain.dto.MemberEntity;
import com.site.diary.domain.repository.MemberRepository;
import com.site.diary.domain.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public Map<String, Object> join(MemberEntity params) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            MemberEntity savedMember = memberRepository.save(params);
            result.put("status", "success");
            result.put("message", "회원가입 성공");
            result.put("memberId", savedMember.getMemberId());
        } catch (Exception e) {
            log.error("회원가입 실패: {}", e.getMessage());
            result.put("status", "fail");
            result.put("message", "회원가입 실패");
        }

        return result;
	}
	
	@Transactional
	@Override
	public Map<String, Object> login(MemberEntity params, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        Optional<MemberEntity> memberOptional = memberRepository.findByMemberId(params.getMemberId());
        // ID 확인
        if (memberOptional.isEmpty()) {
            result.put("status", "fail");
            result.put("message", "아이디가 존재하지 않습니다.");
            return result;
        }
        
        MemberEntity member = memberOptional.get();
        
        // 비밀번호 확인
        if (!passwordEncoder.matches(params.getPw(), member.getPw())) {
            result.put("status", "fail");
            result.put("message", "비밀번호가 일치하지 않습니다.");
            return result;
        }

        // 세션저장 
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", member);
        
        result.put("status", "success");
        result.put("message", "로그인 성공");
        result.put("memberId", member.getMemberId());
        result.put("name", member.getName());
        
        return result;
	}
	
	@Override
	public boolean isMemberIdCheck(String memberId) {
		return memberRepository.existsByMemberId(memberId);
	}

}
