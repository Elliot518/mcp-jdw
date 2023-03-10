package com.mcp.lab.java.concurrency.thread.demo.aqs;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description: 使用CyclicBarrier在多线程中设置屏障, 每个线程执行时都会遇到屏障,
 *               只有当指定数量的线程全部就位时, 现有线程再跨过屏障同时执行。
 *               (eg: 3个人去开会，当最后一个人抵达后， 会议才开始。)
 * @date: Created in 15:50 2022/5/22
 * @modified by:
 */
public class TestCyclicBarrier {

    static class MyThread implements Runnable {
        //用于控制会议开始的屏障
        private CyclicBarrier barrier;
        //参会人员
        private String person;

        public MyThread(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.person = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int) (10000 * Math.random()));
                System.out.println(person + " 已经到会...");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(person + " 开始会议...");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //将屏障设置为3，即当有3个线程执行到await()时，再同时释放
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //三个人去开会
        executor.submit(new MyThread(barrier, "zs"));
        executor.submit(new MyThread(barrier, "ls"));
        executor.submit(new MyThread(barrier, "ww"));
        executor.shutdown();
    }
}




