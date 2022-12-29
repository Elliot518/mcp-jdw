package com.mcp.boot.admin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:18 2022/5/1
 * @modified by:
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages="com.mcp.boot.admin")
public class AdminApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApiApplication.class, args);
    }
}
