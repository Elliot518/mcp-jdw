package com.mcp.demo.springboot.concurrency.simplepool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:57 2022/4/18
 * @modified by:
 */
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class SimplePoolApp {
    public static void main(String[] args) {
        SpringApplication.run(SimplePoolApp.class, args);
    }
}
