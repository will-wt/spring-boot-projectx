package com.will.demo.start.aop;

import com.will.demo.common.JacksonHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Will.WT
 * @date 2022/11/07 23:49
 */
@Component
@Aspect
public class BizAspect {

    private static final Logger sqlLog = LoggerFactory.getLogger("sqlLog");

    @Around("execution(* com.will.demo.dal.mapper..*.*(..))")
    public Object dalAround(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getMethod().getName();
        boolean success = true;

        try {
            return joinPoint.proceed(args);
        } catch (Throwable e) {
            success = false;
            throw new RuntimeException(e);
        } finally {
            long useTime = System.currentTimeMillis() - startTime;
            sqlLog.info("class={};method={};useTime={}ms;success={};args={};result={}",
                    className, methodName, useTime, success, JacksonHelper.toJson(args), null);
        }
    }


}
