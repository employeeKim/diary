package com.site.diary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DiaryApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
		logger.info("app on");
	}

}
