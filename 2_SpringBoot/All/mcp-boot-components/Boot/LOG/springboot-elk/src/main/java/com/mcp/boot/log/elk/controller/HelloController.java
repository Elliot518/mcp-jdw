package com.mcp.boot.log.elk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:25 下午 2021/2/24
 * @modified by:
 */
@Slf4j
@Api(tags = "Hello")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @ApiOperation(value = "Test Log")
    @ResponseBody
    @PostMapping(value = "test-log")
    public Boolean testLog() {
        log.info("Hello KG!");

        return true;
    }
}

