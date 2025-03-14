package com.site.diary.domain.service;

import java.util.Map;

import com.site.diary.domain.dto.MemberEntity;

public interface MemberService {
	Map<String, Object> join(MemberEntity params);
	boolean isMemberIdCheck(String memberId);
}
