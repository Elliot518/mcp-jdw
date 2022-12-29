package com.mcp.boot.high.throughput.controller;

import com.mcp.boot.high.throughput.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author: KG
 * @description:
 * @date: Created in 14:22 2022/5/5
 * @modified by:
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @GetMapping("/sync")
    public String helloSync() {
        log.info("##### {} start hello sync", Thread.currentThread().getName());
        String result = helloService.sayHello();
        log.info("##### {} end hello sync", Thread.currentThread().getName());

        return result;
    }

    /**
     * 异步调用restful
     * 当controller返回值是Callable的时候，springmvc就会启动一个线程将Callable交给TaskExecutor去处理
     * 然后DispatcherServlet还有所有的spring拦截器都退出主线程，然后把response保持打开的状态
     * 当Callable执行结束之后，springmvc就会重新启动分配一个request请求，然后DispatcherServlet就重新
     * 调用和处理Callable异步执行的返回结果， 然后返回视图
     *
     * @return
     */
    @GetMapping("/async")
    public Callable<String> helloAsync() {
        log.info("***** {} start hello async", Thread.currentThread().getName());

        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                log.info(Thread.currentThread().getName() + " 进入call方法");
                String say = helloService.sayHello();
                log.info(Thread.currentThread().getName() + " 从helloService方法返回");
                return say;
            }
        };

        log.info("***** {} end hello async", Thread.currentThread().getName());

        return callable;
    }
}

