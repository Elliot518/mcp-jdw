package com.mcp.demo.cache.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;

import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description: 简单实用Demo
 * @date: Created in 2021年08月28日 10:19 AM
 * @modified by:
 */
public class SimpleDemo {
    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                // 数量上限
                .maximumSize(1024)
                // 过期机制
                .expireAfterWrite(5, TimeUnit.MINUTES)
                // 弱引用key
                .weakKeys()
                // 弱引用value
                .weakValues()
                // 剔除监听
                .removalListener((RemovalListener<String, String>) (key, value, cause) ->
                        System.out.println("key:" + key + ", value:" + value + ", 删除原因:" + cause.toString()))
                .build();

        // 将数据放入本地缓存中
        cache.put("username", "kg");
        cache.put("password", "123456");

        // 从本地缓存中取出数据
        System.out.println(cache.getIfPresent("username"));
        System.out.println(cache.getIfPresent("password"));
        System.out.println(cache.get("blog", key -> {
            // 本地缓存没有的话，从数据库或者Redis中获取
            return getValue(key);
        }));
    }

    private static String getValue(String key) {
        return "getFromRedis";
    }
}

