package com.example.crudapi.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.crudapi..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method started: {}", joinPoint.getSignature());
    }

    @After("execution(* com.example.crudapi..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Method completed: {}", joinPoint.getSignature());
    }
}