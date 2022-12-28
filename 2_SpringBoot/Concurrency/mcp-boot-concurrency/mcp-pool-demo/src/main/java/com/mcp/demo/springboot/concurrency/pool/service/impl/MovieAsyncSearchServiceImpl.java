package com.mcp.demo.springboot.concurrency.pool.service.impl;

import com.mcp.demo.springboot.concurrency.pool.service.IAsyncSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 10:04 PM
 * @modified_by
 */
@Slf4j
@Service
public class MovieAsyncSearchServiceImpl implements IAsyncSearchService<String> {
    private List<String> movies =
            new ArrayList<>(
                    Arrays.asList(
                            "Forrest Gump",
                            "Titanic",
                            "Spirited Away",
                            "The Shawshank Redemption",
                            "Zootopia",
                            "Farewell ",
                            "Joker",
                            "Crawl"));

    /**
     * 找到特定字符/字符串开头的电影
     * @author KG
     * @date 2021/9/25 10:07 PM
     * @param target 目标
     * @return java.util.concurrent.CompletableFuture<java.util.List<java.lang.String>>
     */
    @Async("asyncServiceExecutor")
    @Override
    public CompletableFuture<List<String>> search(String target) {
        // 打印日志
        log.warn(Thread.currentThread().getName() + "start this task!");

        // 找到特定字符/字符串开头的电影

        List<String> results = movies.stream().filter(movie -> movie.startsWith(target)).collect(Collectors.toList());
        // simulate a time consumed task
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            log.error("######### Exception: ", e);
        }

        // 返回一个已经用给定值完成的新的CompletableFuture
        return CompletableFuture.completedFuture(results);
    }
}
