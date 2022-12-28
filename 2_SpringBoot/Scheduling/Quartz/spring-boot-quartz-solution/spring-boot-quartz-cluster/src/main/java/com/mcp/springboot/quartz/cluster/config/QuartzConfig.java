package com.mcp.springboot.quartz.cluster.config;


import com.mcp.springboot.quartz.cluster.job.TestClusterJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: KG
 * @description: 定义任务描述及任务触发规则
 * @date: Created in 22:24 2022/4/12
 * @modified by:
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(TestClusterJob.class)
                // 指定任务的名称
                .withIdentity("testClusterJob")
                // 任务描述
                .withDescription("Job Description: Test Cluster Job")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        //创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .forJob(jobDetail())
                // 每隔 5 秒执行一次 job
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();
    }
}
