package com.mcp.lab.java.core.lambda.stream;

import com.mcp.lab.java.core.lambda.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:45 2023/1/31
 * @modified by:
 */
public class MaxMinDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        Optional<Student> max = students.stream()
                .max(Comparator.comparing(Student::getAge));
        Optional<Student> min = students.stream()
                .min(Comparator.comparing(Student::getAge));
        //判断是否有值
        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);
    }
}
