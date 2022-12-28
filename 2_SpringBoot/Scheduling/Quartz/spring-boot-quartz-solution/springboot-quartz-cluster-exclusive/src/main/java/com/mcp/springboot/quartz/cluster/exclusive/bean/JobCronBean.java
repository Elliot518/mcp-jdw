package com.mcp.springboot.quartz.cluster.exclusive.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月29日 4:13 PM
 * @modified_by
 */
@Component
public class JobCronBean {
    @Value("${job.cron.testJob}")
    private String cronTest;

    public String getCronTest() {
        return cronTest;
    }

    public void setCronTest(String cronTest) {
        this.cronTest = cronTest;
    }
}
