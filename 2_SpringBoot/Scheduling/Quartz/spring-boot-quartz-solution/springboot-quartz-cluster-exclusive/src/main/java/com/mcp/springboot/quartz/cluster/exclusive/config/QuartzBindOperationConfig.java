package com.mcp.springboot.quartz.cluster.exclusive.config;

import com.mcp.springboot.quartz.cluster.exclusive.bean.JobCronBean;
import com.mcp.springboot.quartz.cluster.exclusive.component.QuartzJobFactory;
import com.mcp.springboot.quartz.cluster.exclusive.constant.ScheduledJobEnum;
import com.mcp.springboot.quartz.cluster.exclusive.job.TestSchedule;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月29日 10:33 AM
 * @modified_by
 */
@Slf4j
@Configuration
public class QuartzBindOperationConfig {

    @Autowired
    private QuartzJobFactory quartzJobFactory;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private JobCronBean jobCronBean;

    private void buildScheduler(ScheduledJobEnum jobEnum, String cron, Class<? extends Job> jobClass) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobEnum.getId(), jobEnum.getId())
                .withDescription(jobEnum.getName())
                .build();
        CronScheduleBuilder jobCronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        String jobTriggerName = String.format("%s_TRIGGER", jobEnum.getId());
        CronTrigger jobCronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobTriggerName, jobEnum.getId())
                .withSchedule(jobCronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, jobCronTrigger);
    }

    public void scheduleBind() {
        try {
            scheduler.setJobFactory(quartzJobFactory);

            //buildScheduler(ScheduledJobEnum.JOB_WORD_CLOUD_BATCH_SEGMENT, jobCronBean.getCronWordCloudSegment(), SingleBatchQueueAnalyzeJob.class);
            buildScheduler(ScheduledJobEnum.JOB_TEST, jobCronBean.getCronTest(), TestSchedule.class);

            scheduler.start();
        } catch (SchedulerException e) {
            log.error("##### Quartz Bind Error: ", e);
        }
    }
}



