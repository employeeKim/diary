package com.site.diary.domain.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.diary.domain.dto.LogEntity;
import com.site.diary.domain.repository.LogRepository;
import com.site.diary.domain.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	LogRepository logRepository;

	@Override
	public void saveLogs(String level, String message) {
        LogEntity log = new LogEntity();
        log.setLogLevel(level);
        log.setMessage(message);
        logRepository.save(log);		
	}
	
	@Override
	public List<LogEntity> getAllLogs() {
		return logRepository.findAll();
	}
}
