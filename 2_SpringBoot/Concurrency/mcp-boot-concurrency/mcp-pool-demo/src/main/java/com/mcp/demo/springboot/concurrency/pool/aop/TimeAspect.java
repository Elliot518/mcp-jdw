package com.mcp.demo.springboot.concurrency.pool.aop;

import com.mcp.infrastructure.common.domain.aop.TimeAspector;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 8:25 PM
 * @modified_by
 */
@Aspect
@Component
public class TimeAspect {

    @Pointcut("@annotation(com.mcp.infrastructure.common.domain.aop.Timer)")
    private void pointcut() {}

    @Around("pointcut()")

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return TimeAspector.logAround(joinPoint);
    }
}
