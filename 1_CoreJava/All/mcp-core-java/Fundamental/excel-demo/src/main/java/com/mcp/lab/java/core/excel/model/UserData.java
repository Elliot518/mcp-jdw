package com.mcp.lab.java.core.excel.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.mcp.lab.java.core.excel.easy.SexConverter;
import lombok.Data;

import java.math.BigDecimal;
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

    @ExcelProperty(value = "性别", converter = SexConverter.class)
    private Integer sex;

    // 会以字符串形式生成单元格，要计算的列不推荐
//    @ExcelProperty(value = "体重KG")
//    @NumberFormat("0.##")
//    private BigDecimal weight;

    @ContentStyle(dataFormat = 2)
    private BigDecimal weight;

    // 该字段不生成excel
    @ExcelIgnore
    private String remark;

    private String remark2;
}












