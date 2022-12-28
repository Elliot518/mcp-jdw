package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author KG
 * @description 哪个速度快先返回哪个
 * @date Created in 2021年09月20日 11:33 AM
 * @modified_by
 */
@Slf4j
public class CompletableFutureEitherDemo {
    public static void main(String[] args) {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式A获取商品a";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "通过方式B获取商品a";
        });

        CompletableFuture<String> futureC = futureA.applyToEither(futureB, product -> "结果:" + product);

        // 结果:通过方式A获取商品a
        log.info(futureC.join());
    }
}
