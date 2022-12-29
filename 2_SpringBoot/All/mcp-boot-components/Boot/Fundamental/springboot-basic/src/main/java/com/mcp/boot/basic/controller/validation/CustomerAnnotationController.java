package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.dto.CustomValidDto;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:48 2022/6/8
 * @modified by:
 */
@Api(tags = "自定义注解校验")
@RestController
@RequestMapping("/custom-annotation")
@ResponseResult
public class CustomerAnnotationController {
    @ApiOperation("RequestBody校验")
    @PostMapping("/valid")
    public String validate(@Valid @RequestBody CustomValidDto dto) {
        return "custom valid success";
    }
}

