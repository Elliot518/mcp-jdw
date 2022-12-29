package com.mcp.ddd.skeleton.infra.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.ddd.skeleton.infra.dao.ITaskInfoDao;
import com.mcp.ddd.skeleton.infra.entity.TaskInfo;
import com.mcp.ddd.skeleton.infra.mapper.TaskInfoMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KG
 * @since 2022-04-06
 */
@Repository
public class TaskInfoDaoImpl extends ServiceImpl<TaskInfoMapper, TaskInfo> implements ITaskInfoDao {}

