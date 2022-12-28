package com.mcp.springboot.quartz.cluster.exclusive.constant;

/**
 * @author KG
 * @description 定时任务枚举
 * @date Created in 2021年08月20日 9:21 PM
 * @modified_by
 */
public enum ScheduledJobEnum {

    JOB_TEST("JOB_TEST", "测试任务");

    private final String id;
    private final String name;

    private ScheduledJobEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ScheduledJobEnum match(String code){
        for (ScheduledJobEnum item: ScheduledJobEnum.values()) {
            if (item.id.equals(code)) {
                return item;
            }
        }

        return null;
    }
}


