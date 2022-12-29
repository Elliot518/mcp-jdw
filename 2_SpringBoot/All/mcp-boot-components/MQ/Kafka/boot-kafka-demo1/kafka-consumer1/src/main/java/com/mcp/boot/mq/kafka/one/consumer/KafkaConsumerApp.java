package com.mcp.boot.mq.kafka.one.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:18 2022/5/14
 * @modified by:
 */
@SpringBootApplication
public class KafkaConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class,args) ;
    }
}

