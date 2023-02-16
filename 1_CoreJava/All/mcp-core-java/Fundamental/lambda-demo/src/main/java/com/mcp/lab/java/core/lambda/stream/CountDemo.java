package com.mcp.lab.java.core.lambda.stream;

import com.mcp.lab.java.core.lambda.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:50 2023/1/31
 * @modified by:
 */
public class CountDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        long count = students.stream().filter(s1 -> s1.getAge() < 45).count();
        System.out.println("年龄小于45岁的人数是：" + count);
    }
}

