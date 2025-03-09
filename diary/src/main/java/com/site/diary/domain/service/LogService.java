package com.site.diary.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.diary.domain.dto.LogEntity;

public interface LogService {
	void saveLogs(String level, String message);
	List<LogEntity> getAllLogs();
}
