package com.site.diary.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.site.diary.domain.service.LogService;

@Aspect //AOP 기능 사용을 위한 어노테이션
@Component //자동으로 빈으로 등록
public class LoggingAspect {

    @Autowired
    private LogService logService;  //로그 저장을 위한 서비스

    //메서드 실행 전에 로그 저장
    @Before("execution(* com.site.diary.domain.web..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logService.saveLogs("INFO", "페이지 요청 : " + methodName);
    }

    //메서드 실행 후 로그 저장
    @AfterReturning("execution(* com.site.diary.domain.web..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logService.saveLogs("INFO", "메서드 실행 완료 : " + methodName);
    }

    //예외 발생 시 에러 로그 저장
    @AfterThrowing(pointcut = "execution(* com.site.diary.domain.web..*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().toShortString();
        logService.saveLogs("ERROR", "에러 발생 : " + methodName + " - " + ex.getMessage());
    }
}

