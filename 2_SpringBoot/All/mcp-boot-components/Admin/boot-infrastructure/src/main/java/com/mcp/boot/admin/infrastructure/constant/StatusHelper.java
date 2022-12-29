package com.mcp.boot.admin.infrastructure.constant;

/**
 * @author: KG
 * @description:
 * @date: Created in 19:26 2022/4/14
 * @modified by:
 */
public class StatusHelper {
    public static String match(int code, IStatusCode[] values){
        for (IStatusCode item: values) {
            if (item.getId() == code) {
                return item.getStatus();
            }
        }

        return "";
    }
}
