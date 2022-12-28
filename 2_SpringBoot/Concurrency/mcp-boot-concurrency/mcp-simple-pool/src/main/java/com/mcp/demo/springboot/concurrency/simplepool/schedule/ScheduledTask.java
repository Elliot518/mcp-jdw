package com.mcp.demo.springboot.concurrency.simplepool.schedule;

import com.mcp.demo.springboot.concurrency.simplepool.exception.BusinessException;
import com.mcp.demo.springboot.concurrency.simplepool.exception.BusinessResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: KG
 * @description:
 * @date: Created in 14:22 2022/4/18
 * @modified by:
 */
@Slf4j
@Component
public class ScheduledTask {
    /*
     * 指定自定义线程池
     * @author KG
     * @date 2022/4/18 14:39
     */
    @Async("asyncTaskExecutor")
    @Scheduled(cron = "${scheduled.task.cron}")
    public void scheduledTask1() throws InterruptedException {
        log.info("########## Thread: {}, Task: {} executed at time millis: {}", Thread.currentThread().getName(), "scheduledTask1", System.currentTimeMillis());
    }

   /**
    * 未指定线程池，则使用默认线程池(或全局线程池)
    * @author KG
    * @date 2022/4/18 14:40
    */
    @Scheduled(cron = "${scheduled.task.cron}")
    @Async
    public void scheduledTask2() {
        log.info("********** Thread: {}, Task: {} executed at time millis: {}", Thread.currentThread().getName(), "scheduledTask2", System.currentTimeMillis());
    }

    @Scheduled(cron = "${scheduled.task.cron}")
    @Async
    public void scheduledTask3() {
        throw new BusinessException(BusinessResultCode.THREAD_EXECUTE_ERROR);
    }
}
