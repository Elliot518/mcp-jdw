package com.mcp.boot.high.throughput.service.impl;

import com.mcp.boot.high.throughput.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 14:25 2022/5/5
 * @modified by:
 */
@Slf4j
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("#####Exception: ", e);
        }
        return "Hello KG";
    }
}
