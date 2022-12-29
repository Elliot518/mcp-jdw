package com.mcp.boot.mq.kafka.one.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: KG
 * @description:
 * @date: Created in 16:15 2022/5/14
 * @modified by:
 */
@SpringBootApplication
public class KafkaProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class,args) ;
    }
}

