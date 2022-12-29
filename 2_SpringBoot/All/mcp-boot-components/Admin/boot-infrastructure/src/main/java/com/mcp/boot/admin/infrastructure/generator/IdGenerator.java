package com.mcp.boot.admin.infrastructure.generator;

import cn.hutool.core.util.RandomUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: KG
 * @description: ID生成器
 * @date: Created in 2021年09月15日 2:57 PM
 * @modified by:
 */
public class IdGenerator {
    private static final String TIME_PATTERN = "yyyyMMddHHmmssSSS";
    private static final int RAND_NUM = 3;

    /**
     * 按照指定格式把时间转换成字符串，格式的写法类似yyyy-MM-dd HH:mm:ss.SSS
     * @param date    时间
     * @param pattern 格式
     * @return 时间字符串
     */
    private static String date2String(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat(pattern)).format(date);
    }

    /**
     * 根据UUID(忽略中划线)生成ID
     * @return java.lang.String UUID去掉-
     * @author KG
     * @date 2021/9/15 2:58 PM
     */
    public static String getUid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 根据当前时间(精确到毫秒)生成时间戳ID + 尾部3位随机数(共20位)
     * @return java.lang.String 毫秒ID
     * @author KG
     * @date 2021/9/15 2:59 PM
     */
    public static String getTimeId() {
        Date date = new Date();
        return date2String(date, TIME_PATTERN) + RandomUtil.randomNumbers(RAND_NUM);
    }

    /**
     * 带业务前缀20+位时间ID
     * @param bizPrefix
     * @return java.lang.String
     * @author KG
     * @date 2021/9/15 4:58 PM
     */
    public static String getBizTimeId(String bizPrefix) {
        String id = getTimeId();

        return String.format("%s%s", bizPrefix, id);
    }
}











