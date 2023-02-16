package com.mcp.lab.java.core.lambda.stream;

import com.mcp.lab.java.core.lambda.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:34 2023/1/31
 * @modified by:
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        List<Student> studentList = Stream.of(students,
                Arrays.asList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(studentList);
    }
}
