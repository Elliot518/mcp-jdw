package com.mcp.boot.admin.infrastructure.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;

/**
 * @author: KG
 * @description: 阿里巴巴Fastjson封装工具类
 * @date: Created in 15:29 2022/4/20
 * @modified by:
 */
public class FastJsonUtils {

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * JSON字符串转换成指定的java对象
     * @author KG
     * @date 2022/4/20 15:43
     * @param jsonString JSON字符串
     * @param clazz 指定的java对象
     * @return T
     */
    public static <T> T fromStringToObj(String jsonString, Class<T> clazz) {
        if (isEmpty(jsonString)) {
            return null;
        }

        return JSONObject.parseObject(jsonString, clazz);
    }

    /**
     * JSON字符串转换成指定的java对象列表
     *
     * @param jsonString JSON字符串
     * @param clazz    指定的java对象
     * @return java.util.List<T>
     * @author KG
     * @date 2022/4/20 15:30
     */
    public static <T> List<T> fromStringToList(String jsonString, Class<T> clazz) {
        if (isEmpty(jsonString)) {
            return Collections.emptyList();
        }

        return JSON.parseArray(jsonString, clazz);
    }

    /**
     * 指定的java对象转换成json字符串
     * @author KG
     * @date 2022/4/20 15:47
     * @param obj 指定的java对象
     * @return java.lang.String
     */
    public static <T> String fromObjToString(T obj){
        return JSONObject.toJSONString(obj);
    }

    /**
     * 指定的java对象列表转换成json字符串
     * @author KG
     * @date 2022/4/20 15:50
     * @param objList 指定的java对象列表
     * @return java.lang.String
     */
    public static<T> String fromListToJsonString(List<T> objList){
        return JSONObject.toJSONString(objList);
    }
}














