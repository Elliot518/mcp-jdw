package com.mcp.demo.springboot.concurrency.pool.service.impl;

import com.mcp.demo.springboot.concurrency.pool.service.ISyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 7:29 PM
 * @modified_by
 */
@Slf4j
@Service
public class SyncServiceImpl implements ISyncService {
    @Override
    public void execute() throws Exception {
        log.info("### start execute... ###");

        Thread.sleep(5000);
        log.info("Thread: {} -- Sync Service Logic Executed!", Thread.currentThread().getName());

        log.info("### end execute! ###");
    }
}
