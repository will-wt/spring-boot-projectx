package com.will.demo.start.aop;

import com.will.demo.common.JacksonHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Will.WT
 * @date 2022/11/07 23:49
 */
@Aspect
public class BizAspect {

    private static final Logger sqlLog = LoggerFactory.getLogger("sqlLog");

    @Around(value = "execution(* com.will.demo.dal.mapper.*.*.*(..))")
    public Object dalAround(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getMethod().getName();

        try {
            return joinPoint.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            long useTime = System.currentTimeMillis() - startTime;
            sqlLog.info("class={};method={};useTime={};args={};result={}",
                    className, methodName, useTime, JacksonHelper.toJson(args), null);
        }
    }


}
