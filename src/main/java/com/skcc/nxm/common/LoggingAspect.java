package com.skcc.nxm.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * Before: 대상 “메서드”가 실행되기 전에 Advice를 실행
     */
    @Before(value = "execution(* com.skcc.nxm.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("##### Before method  : " + joinPoint.getSignature().getName() + " #####");
    }


    /**
     * After : 대상 “메서드”가 실행된 후에 Advice를 실행
     */
    @After("execution(* com.skcc.nxm.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("##### After method  : " + joinPoint.getSignature().getName() + " #####");
    }

    /**
     * AfterReturning: 대상 “메서드”가 정상적으로 실행되고 반환된 후에 Advice를 실행
     */
    @AfterReturning(pointcut = "execution(* com.skcc.nxm.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("##### AfterReturning: " + joinPoint.getSignature().getName() + " result: " + result + " #####");
    }

    /**
     * AfterThrowing: 대상 “메서드에서 예외가 발생”했을 때 Advice를 실행
     */
    @AfterThrowing(pointcut = "execution(* com.skcc.nxm.controller.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("##### AfterThrowing: " + joinPoint.getSignature().getName() + " exception: " + e.getMessage() +" #####");
    }

    /**
     * Around : 대상 “메서드” 실행 전, 후 또는 예외 발생 시에 Advice를 실행
     */
    @Around("execution(* com.skcc.nxm.controller.*.*(..))" )
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info("===== Around before: " + joinPoint.getSignature().getName());


        //조인포인트 호출 전에 시작 시간 측정
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        //조인포인트 호출 후에 끝난 시간 측정
        long endTime = System.currentTimeMillis();
        //시작, 종료 시간을 빼서 동작 시간 측정
        long elapsedTime = endTime - startTime;
        log.info("Request: {} : {} : {} : ({}ms)" ,request.getMethod(),request.getRequestURL(), joinPoint.getArgs(),elapsedTime );
        log.info("===== Around after: " + joinPoint.getSignature().getName());
        return result;
    }


}
