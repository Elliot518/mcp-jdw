package com.mcp.demo.springboot.concurrency.pool.controller;

import com.mcp.demo.springboot.concurrency.pool.service.IAsyncSearchService;
import com.mcp.infrastructure.common.domain.aop.Timer;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 10:09 PM
 * @modified_by
 */
@Slf4j
@Api(tags = "异步搜索测试")
@RestController
@RequestMapping("/test-movie")
@ResponseResult
public class TestMovieController {
    @Autowired
    private IAsyncSearchService<String> asyncService;

    @Timer
    @GetMapping("/movies")
    public String completableFutureTask() throws ExecutionException, InterruptedException {


        // 开始执行大量的异步任务
        List<String> words = Arrays.asList("F", "T", "S", "Z", "J", "C");
        List<CompletableFuture<List<String>>> completableFutureList = words.stream()
                .map(word -> asyncService.search(word))
                .collect(Collectors.toList());

        // CompletableFuture.join() 方法可以获取他们的结果并将结果连接起来
        List<List<String>> results = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());

        return results.toString();
    }
}









