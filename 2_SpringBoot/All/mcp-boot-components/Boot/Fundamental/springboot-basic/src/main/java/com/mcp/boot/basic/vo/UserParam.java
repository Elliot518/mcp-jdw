package com.mcp.boot.basic.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:49 2022/6/8
 * @modified by:
 */
@Data
public class UserParam {
    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "手机号不能为空")
    @Max(value = 11)
    private String phone;

    @NotNull(message = "邮箱不能为空")
    private String email;
}
