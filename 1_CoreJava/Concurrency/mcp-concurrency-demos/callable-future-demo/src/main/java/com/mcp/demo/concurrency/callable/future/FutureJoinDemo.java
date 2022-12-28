package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月20日 2:48 PM
 * @modified_by
 */
@Slf4j
public class FutureJoinDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return  "hello";
        }, executorService);
        CompletableFuture<String> futureB = futureA.thenApply(s -> s + " world");
        CompletableFuture<String> future3 = futureB.thenApply(String::toUpperCase);

        log.info(future3.join());
    }
}
