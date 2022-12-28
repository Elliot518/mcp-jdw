package com.mcp.springboot.quartz.cluster.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * @author: KG
 * @description: 定义任务类
 * @date: Created in 22:22 2022/4/12
 * @modified by:
 */
@Slf4j
public class TestClusterJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Test Cluster Job Start...");
    }
}
