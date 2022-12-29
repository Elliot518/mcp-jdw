package com.mcp.boot.basic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:01 2022/6/8
 * @modified by:
 */
@Data
public class AddUserParamsDto implements Serializable {

    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Length(min = 6, message = "密码长度不能小于6")
    private String password;

    @Max(value = 120, message = "年龄必须在18-120之间")
    @Min(value = 18, message = "年龄必须在18-120之间")
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String description;
}



