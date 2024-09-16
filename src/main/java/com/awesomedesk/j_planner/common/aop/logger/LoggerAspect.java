package com.awesomedesk.j_planner.common.aop.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LoggerAspect {
    @Around("execution(* *..*Controller.*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        log.info("[Controller methodName] : {}", name);

        return joinPoint.proceed();
    }

    @Around("execution(* com.awesomedesk.j_planner.common.response.exception.*(..))")
    public Object doAwesomeErrorLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        log.info("[Error methodName] : {}", name);
        log.info("[Error methodArgs] : {}", joinPoint.getArgs());

        return joinPoint.proceed();
    }
}
