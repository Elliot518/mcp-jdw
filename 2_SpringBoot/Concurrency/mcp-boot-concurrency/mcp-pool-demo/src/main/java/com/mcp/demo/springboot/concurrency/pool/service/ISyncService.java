package com.mcp.demo.springboot.concurrency.pool.service;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 7:28 PM
 * @modified_by
 */
public interface ISyncService {
    /**
     * 执行同步任务
     */
    void execute() throws Exception;
}
