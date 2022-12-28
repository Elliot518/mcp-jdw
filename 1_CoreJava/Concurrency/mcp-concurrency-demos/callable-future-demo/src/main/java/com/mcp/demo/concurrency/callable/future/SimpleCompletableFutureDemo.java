package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月20日 11:54 AM
 * @modified_by
 */
@Slf4j
public class SimpleCompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 执行任务
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }, executorService);

        // print immediately
        log.info("{} - main thread", Thread.currentThread().getName());

        // print after some time
        log.info("{} - {}", Thread.currentThread().getName(), future.get());
    }
}
