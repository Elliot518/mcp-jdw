package com.mcp.demo.springboot.concurrency.pool.service.impl;

import com.mcp.demo.springboot.concurrency.pool.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 7:29 PM
 * @modified_by
 */
@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() throws Exception {
        log.info("### start executeAsync... ###");

        Thread.sleep(5000);
        log.info("Thread: {} -- Async Service Logic Executed!", Thread.currentThread().getName());

        log.info("### end executeAsync! ###");
    }
}
