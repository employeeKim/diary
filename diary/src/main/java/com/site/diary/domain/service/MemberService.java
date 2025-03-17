package com.site.diary.domain.service;

import java.util.Map;

import com.site.diary.domain.dto.MemberEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface MemberService {
	Map<String, Object> join(MemberEntity params);
	Map<String, Object> login(MemberEntity params, HttpServletRequest request);
	boolean isMemberIdCheck(String memberId);
}
