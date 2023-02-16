package com.mcp.lab.java.core.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:29 2023/1/31
 * @modified by:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;

    private int age;

    private double height;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                "}\n";
    }
}
