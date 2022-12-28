package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KG
 * @description 执行过程中抛出异常, 则使用默认值
 *              执行流程: supplyAsync->whenComplete->exceptionally
 * @date Created in 2021年09月20日 6:51 PM
 * @modified_by
 */
@Slf4j
public class FutureExceptionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "执行结果:" + (100 / 0), executorService)
                .thenApply(s -> "futureA result:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        // 未执行
                        log.info(s);
                    }
                    if (e == null) {
                        // 未执行
                        log.info(s);
                    } else {
                        // java.lang.ArithmeticException: / by zero
                        log.error(e.getMessage());
                    }
                })
                .exceptionally(e -> {
                    log.error("#####Exception: ", e);
                    return "futureA result: 100";
                });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "执行结果:" + 50, executorService)
                .thenApply(s -> "futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");

        // futureA result: 100
        log.info(futureA.join());
        // futureB result:执行结果:50
        log.info(futureB.join());
    }
}

