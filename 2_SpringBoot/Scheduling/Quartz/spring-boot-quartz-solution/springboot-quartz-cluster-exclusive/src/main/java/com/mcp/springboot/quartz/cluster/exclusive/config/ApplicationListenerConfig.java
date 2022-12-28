package com.mcp.springboot.quartz.cluster.exclusive.config;

import com.mcp.springboot.quartz.cluster.exclusive.dao.IQrtzJobDetailsDao;
import com.mcp.springboot.quartz.cluster.exclusive.entity.QrtzJobDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月29日 10:39 AM
 * @modified_by
 */
@Slf4j
@Configuration
public class ApplicationListenerConfig implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private QuartzBindOperationConfig quartzBindOperationConfig;

    @Autowired
    private IQrtzJobDetailsDao qrtzJobDetailsDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<QrtzJobDetails> qrtzJobDetailsList = qrtzJobDetailsDao.list();

        if (CollectionUtils.isEmpty(qrtzJobDetailsList)) {
            quartzBindOperationConfig.scheduleBind();
        }
    }
}


