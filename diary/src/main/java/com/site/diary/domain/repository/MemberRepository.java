package com.site.diary.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.diary.domain.dto.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	// 아이디 중복체크
	boolean existsByMemberId(String memberId);
	// 아이디로 회원 찾기
	Optional<MemberEntity> findByMemberId(String memberId);
}
