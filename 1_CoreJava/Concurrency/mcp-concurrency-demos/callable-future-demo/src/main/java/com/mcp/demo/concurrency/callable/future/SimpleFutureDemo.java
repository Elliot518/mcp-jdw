package com.mcp.demo.concurrency.callable.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author KG
 * @description Callable + Future简单例子
 * @date Created in 2021年09月20日 10:45 AM
 * @modified_by
 */
@Slf4j
public class SimpleFutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executor.submit(() -> {
            Thread.sleep(5000);
            // print after some time
            log.info("{} returns", Thread.currentThread().getName());
            return "async thread";
        });

        // print immediately
        log.info("{} - main thread", Thread.currentThread().getName());

        // print after some time
        log.info("{} - {}", Thread.currentThread().getName(), stringFuture.get());
    }
}


