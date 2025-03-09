package com.site.diary.domain.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logs")
public class LogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long id;
    private String logLevel;
    private String message;
    @Column(columnDefinition = "TEXT") // 긴 문자열 저장
    private String exception;
    @CreationTimestamp // 로그 발생시간 자동 기록
    private LocalDateTime timestamp;
	
}
