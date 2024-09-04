package com.example.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogMethodAspect {

    @Pointcut(value = "execution(* com.example.library.service..*(..))")
    public void forServiceLog() {
    }

    @Pointcut(value = "execution(* com.example.library.repository..*(..))")
    public void forRepositoryLog() {
    }

    @Pointcut(value = "forServiceLog() || forRepositoryLog() ")
    public void forAllAppLog() {
    }

    @Around("forAllAppLog()")  
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method {} is called with arguments: {}", methodName, joinPoint.getArgs());

        Object result = joinPoint.proceed();

        log.info("Method {} returned: {}", methodName, result);

        return result;
    }

}
