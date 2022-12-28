package com.mcp.demo.springboot.concurrency.simplepool.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @author: KG
 * @description:
 * @date: Created in 15:24 2022/4/18
 * @modified by:
 */
@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        // 处理异常
        log.info("Exception caught: {}", method.getName());
    }
}
