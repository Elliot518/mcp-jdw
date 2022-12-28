package com.mcp.demo.cache.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description: 简单实用Demo
 * @date: Created in 2021年08月28日 10:19 AM
 * @modified by:
 */
public class ListDemo {
    public static void main(String[] args) {
        Cache<String, List<String>> cache = Caffeine.newBuilder()
                // 数量上限
                .maximumSize(1024)
                // 过期机制
                .expireAfterWrite(5, TimeUnit.MINUTES)
                // 弱引用key
                .weakKeys()
                // 弱引用value
                .weakValues()
                // 剔除监听
                .removalListener((RemovalListener<String, List<String>>) (key, value, cause) ->
                        System.out.println("key:" + key + ", value:" + value + ", 删除原因:" + cause.toString()))
                .build();

        // 将数据放入本地缓存中
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");

        cache.put("cacheList", arrayList);

        // 从本地缓存中取出数据
        List<String> cacheList = cache.getIfPresent("cacheList");
        cacheList.stream().forEach(System.out::println);
    }
}

