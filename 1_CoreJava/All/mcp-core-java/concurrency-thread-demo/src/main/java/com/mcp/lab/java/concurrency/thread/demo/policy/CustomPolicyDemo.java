package com.mcp.lab.java.concurrency.thread.demo.policy;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:56 2022/4/17
 * @modified by:
 */
public class CustomPolicyDemo {
    public static void main(String[] args) {
        // 任务的具体方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前任务被执行,执行时间:" + new Date() +
                        " 执行线程:" + Thread.currentThread().getName());
                try {
                    // 等待 1s
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 创建线程,线程的任务队列的长度为 1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        // 执行自定义拒绝策略的相关操作
                        System.out.println("我是自定义拒绝策略");
                    }
                });
        // 添加并执行 4 个任务
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
    }
}




