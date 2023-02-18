package com.mcp.lab.java.core.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.mcp.lab.java.core.excel.model.UserData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 19:57 2023/2/17
 * @modified by:
 */
public class IgnoreByCodeDemo {
    public static void main(String[] args) {
        String fileName = "/Users/kg/Downloads/student.xlsx";

        EasyExcel.write(fileName, UserData.class).sheet("学生信息表").excludeColumnFiledNames(Arrays.asList("remark2")).doWrite(getData());

        System.out.println("Excel file: " + fileName + " write successfully!");
    }

    public static Date formatDate(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<UserData> getData() {
        List<UserData> list = new ArrayList<>();

        UserData userData1 = new UserData();
        userData1.setUsername("张三");
        userData1.setAge(22);
        userData1.setBirthday(formatDate("2000-10-11"));
        userData1.setRemark("Remark1");
        userData1.setRemark2("Remark1");
        list.add(userData1);

        UserData userData2 = new UserData();
        userData2.setUsername("李四");
        userData2.setAge(23);
        userData2.setBirthday(formatDate("1999-5-3"));
        userData2.setRemark("Remark2");
        userData2.setRemark2("Remark2");
        list.add(userData2);

        return list;
    }
}
