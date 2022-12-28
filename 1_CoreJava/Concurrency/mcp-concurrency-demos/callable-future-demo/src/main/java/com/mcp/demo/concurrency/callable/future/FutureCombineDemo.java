package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月20日 3:00 PM
 * @modified_by
 */
@Slf4j
public class FutureCombineDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 100d;
        }, executorService);
        CompletableFuture<Double> futureDiscount = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 0.8;
        }, executorService);
        CompletableFuture<Double> futureResult = futurePrice.thenCombine(futureDiscount, (price, discount) -> price * discount);

        // final price is: 80.0
        log.info("Final Price: {}", futureResult.join());
    }
}

