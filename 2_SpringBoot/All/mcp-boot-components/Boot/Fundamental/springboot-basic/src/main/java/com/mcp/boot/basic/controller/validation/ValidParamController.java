package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.vo.ValidVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:44 2022/5/8
 * @modified by:
 */
@RestController
@Slf4j
@RequestMapping("/valid-param")
@Validated
public class ValidParamController {

    @ApiOperation("Form校验")
    @PostMapping(value = "/test2")
    public String test2(@Valid ValidVO validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";
    }

    @ApiOperation("单参数校验")
    @PostMapping(value = "/test3")
    public String test3(@Email @RequestParam(value = "email") String email){
        log.info("email is {}", email);
        return "email valid success";
    }
}



