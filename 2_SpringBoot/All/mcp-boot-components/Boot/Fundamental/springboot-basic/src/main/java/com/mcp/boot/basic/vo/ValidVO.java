package com.mcp.boot.basic.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:52 2022/5/8
 * @modified by:
 */
@Data
public class ValidVO {
    private String id;

    @Length(min = 6, max = 12, message = "appId长度必须位于6到12之间")
    private String appId;

    @NotBlank(message = "名字为必填项")
    private String name;

    @Email(message = "请填写正确的邮箱地址")
    private String email;

    private String sex;

    @NotEmpty(message = "级别不能为空")
    private String level;
}

