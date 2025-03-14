package com.site.diary.domain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.diary.domain.dto.MemberEntity;
import com.site.diary.domain.repository.MemberRepository;
import com.site.diary.domain.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Transactional
	@Override
	public Map<String, Object> join(MemberEntity params) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            log.info("회원가입 요청: {}", params);
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
	
	@Override
	public boolean isMemberIdCheck(String memberId) {
		return memberRepository.existsByMemberId(memberId);
	}

}
