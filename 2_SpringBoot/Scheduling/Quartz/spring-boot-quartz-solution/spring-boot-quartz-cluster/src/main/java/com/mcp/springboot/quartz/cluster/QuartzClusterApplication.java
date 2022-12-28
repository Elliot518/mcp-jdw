package com.mcp.springboot.quartz.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:06 2022/4/12
 * @modified by:
 */
@EnableScheduling
@SpringBootApplication
public class QuartzClusterApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzClusterApplication.class, args);
    }
}
