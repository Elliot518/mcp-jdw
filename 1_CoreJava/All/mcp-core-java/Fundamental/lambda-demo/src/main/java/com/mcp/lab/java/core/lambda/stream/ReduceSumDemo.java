package com.mcp.lab.java.core.lambda.stream;

import java.util.stream.Stream;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:53 2023/1/31
 * @modified by:
 */
public class ReduceSumDemo {
    public static void main(String[] args) {
        Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
