package com.mcp.springboot.quartz.cluster.exclusive.job;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月29日 10:35 AM
 * @modified_by
 */

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

@Slf4j
@DisallowConcurrentExecution
public class TestSchedule implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("***** quartz test job: " + new Date());
    }
}
