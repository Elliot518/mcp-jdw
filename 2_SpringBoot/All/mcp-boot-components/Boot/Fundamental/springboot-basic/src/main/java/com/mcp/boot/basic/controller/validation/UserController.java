package com.mcp.boot.basic.controller.validation;

import com.mcp.boot.basic.dto.AddUserParamsDto;
import com.mcp.boot.basic.service.UserService;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:15 2022/6/8
 * @modified by:
 */
@Api(tags = "服务层校验(service校验)")
@RestController
@RequestMapping("/user")
@ResponseResult
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/valid-by-service")
    public void validByService(@RequestBody AddUserParamsDto dto) {
        userService.validByService(dto);
    }

    @PostMapping("/valid-list-by-service")
    public void validListByService(@RequestBody List<AddUserParamsDto> dtoList) {
        userService.validListByService(dtoList);
    }
}



