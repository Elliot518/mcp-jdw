package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.vo.UserParam;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:51 2022/6/8
 * @modified by:
 */
@Api(tags = "用户校验(springboot校验)")
@ResponseResult
@RestController
@RequestMapping("user-valid")
public class UserValidationController {
    @PostMapping("addUser")
    public String addUser(@Valid @RequestBody UserParam userParam) {

        //todo 插入用户信息表
        return "SUCCESS";
    }
}
