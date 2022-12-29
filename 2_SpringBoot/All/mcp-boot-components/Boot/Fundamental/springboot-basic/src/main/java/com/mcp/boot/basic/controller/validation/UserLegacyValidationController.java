package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.vo.UserParam;
import com.mcp.boot.basic.vo.UserReq;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:47 2022/6/8
 * @modified by:
 */
@Api(tags = "用户校验(传统校验)")
@ResponseResult
@RestController
@RequestMapping("user-legacy-valid")
public class UserLegacyValidationController {

    @PostMapping("user")
    public String addUser(UserReq req) {

        if (StringUtils.isEmpty(req.getUserName())) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(req.getPhone())) {
            return "手机号不能为空";
        }
        if (req.getPhone().length() > 11) {
            return "手机号不能超过11";
        }
        if (StringUtils.isEmpty(req.getEmail())) {
            return "邮箱不能为空";
        }

        //省略其他业务逻辑


        return "SUCCESS";
    }
}


