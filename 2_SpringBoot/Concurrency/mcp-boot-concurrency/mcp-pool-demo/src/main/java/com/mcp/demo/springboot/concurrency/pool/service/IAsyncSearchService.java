package com.mcp.demo.springboot.concurrency.pool.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 9:57 PM
 * @modified_by
 */
public interface IAsyncSearchService<T> {
    /**
     * search by async
     * @author KG
     * @date 2021/9/25 10:03 PM
     * @param target search target
     * @return java.util.concurrent.CompletableFuture<java.util.List<T>>
     */
    CompletableFuture<List<T>> search(T target);
}
