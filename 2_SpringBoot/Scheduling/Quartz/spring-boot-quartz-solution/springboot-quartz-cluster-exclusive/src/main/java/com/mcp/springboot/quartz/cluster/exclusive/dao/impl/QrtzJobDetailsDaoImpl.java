package com.mcp.springboot.quartz.cluster.exclusive.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.springboot.quartz.cluster.exclusive.dao.IQrtzJobDetailsDao;
import com.mcp.springboot.quartz.cluster.exclusive.entity.QrtzJobDetails;
import com.mcp.springboot.quartz.cluster.exclusive.mapper.QrtzJobDetailsMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KG
 * @since 2022-04-16
 */
@Repository
public class QrtzJobDetailsDaoImpl extends ServiceImpl<QrtzJobDetailsMapper, QrtzJobDetails> implements IQrtzJobDetailsDao {}