package com.mcp.boot.basic.dto;

import com.mcp.infrastructure.common.domain.validation.EnumString;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:56 2022/6/8
 * @modified by:
 */
@Data
public class CustomValidDto {
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Length(min = 6, message = "密码长度不能小于6")
    private String password;

    @ApiModelProperty(value = "性别")
    @EnumString(value = {"F","M"}, message="性别只允许为F或M")
    private String sex;
}
