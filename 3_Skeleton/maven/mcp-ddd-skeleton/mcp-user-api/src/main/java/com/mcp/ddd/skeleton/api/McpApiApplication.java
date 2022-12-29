package com.mcp.ddd.skeleton.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:08 上午 2022/3/28
 * @modified by:
 */
@SpringBootApplication(scanBasePackages="com.mcp.ddd.skeleton")
public class McpApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(McpApiApplication.class, args);
    }
}
