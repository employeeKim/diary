package com.site.diary.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.diary.domain.dto.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long>{
}
