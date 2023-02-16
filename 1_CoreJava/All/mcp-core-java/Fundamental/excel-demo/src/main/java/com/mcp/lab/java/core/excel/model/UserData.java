package com.mcp.lab.java.core.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:16 2023/2/16
 * @modified by:
 */
@Data
public class UserData {

    @ExcelProperty(index = 0, value = "姓名")
    private String username;

    @ExcelProperty(index = 1, value = "年龄")
    private int age;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 2, value = "生日")
    private Date birthday;
}
