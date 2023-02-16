package com.mcp.lab.java.core.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.mcp.lab.java.core.excel.model.UserData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 22:23 2023/2/16
 * @modified by:
 */
public class EasyExcelWriteDemo {

    public static void main(String[] args) {
        // 实现excel写操作
        //1.设置写入文件夹地址和excel文件名称
        String fileName = "/Users/kg/Downloads/student.xlsx";
        //调用easyExcel里面的方法实现写操作
        //2个参数，第一个参数是文件名称，第二个参数是实体类
        EasyExcel.write(fileName, UserData.class).sheet("学生信息表").doWrite(getData());

        System.out.println("Excel file: " + fileName + " write successfully!");
    }

    //创建方法返回list集合
    public static List<UserData> getData() {
        List<UserData> list = new ArrayList<>();

        UserData userData1 = new UserData();
        userData1.setUsername("张三");
        userData1.setAge(22);
        userData1.setBirthday(formatDate("2000-10-11"));
        list.add(userData1);

        UserData userData2 = new UserData();
        userData2.setUsername("李四");
        userData2.setAge(23);
        userData2.setBirthday(formatDate("1999-5-3"));
        list.add(userData2);

        return list;
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
}
