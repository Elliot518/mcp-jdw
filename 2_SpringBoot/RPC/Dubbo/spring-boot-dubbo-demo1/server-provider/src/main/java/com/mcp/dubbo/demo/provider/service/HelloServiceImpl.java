package com.mcp.dubbo.demo.provider.service;

import com.mcp.dubbo.demo.common.api.HelloService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}
