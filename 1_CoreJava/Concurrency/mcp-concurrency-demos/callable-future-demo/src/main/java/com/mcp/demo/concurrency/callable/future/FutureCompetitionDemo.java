package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KG
 * @description 两个线程竞争, 哪个先返回就用哪个
 * @date Created in 2021年09月20日 6:40 PM
 * @modified_by
 */
@Slf4j
public class FutureCompetitionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Get from A";
        }, executorService);
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Get from B";
        }, executorService);

        // Result: Get from A
        CompletableFuture<String> futureC = futureA.applyToEither(futureB, product -> "Result: " + product);
        log.info(futureC.join());
    }
}
