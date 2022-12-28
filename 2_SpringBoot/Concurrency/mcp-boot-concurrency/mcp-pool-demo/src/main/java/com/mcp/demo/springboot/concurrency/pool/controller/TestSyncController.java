package com.mcp.demo.springboot.concurrency.pool.controller;

import com.mcp.demo.springboot.concurrency.pool.service.ISyncService;
import com.mcp.infrastructure.common.domain.aop.Timer;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 7:39 PM
 * @modified_by
 */
@Slf4j
@Api(tags = "同步测试")
@RestController
@RequestMapping("/test-sync")
@ResponseResult
public class TestSyncController {
    @Autowired
    private ISyncService syncService;

    @Timer
    @GetMapping("/sync")
    public void async() throws Exception {
        for (int i = 0; i < 10; i++) {
            syncService.execute();
        }
    }
}
