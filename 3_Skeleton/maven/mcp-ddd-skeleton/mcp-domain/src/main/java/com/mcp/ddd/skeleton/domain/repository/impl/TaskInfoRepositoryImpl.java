package com.mcp.ddd.skeleton.domain.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcp.ddd.skeleton.domain.repository.ITaskInfoRepository;
import com.mcp.ddd.skeleton.infra.dao.ITaskInfoDao;
import com.mcp.ddd.skeleton.infra.entity.TaskInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午8:33 2022/4/7
 * @modified by:
 */
@Repository
public class TaskInfoRepositoryImpl implements ITaskInfoRepository {

    @Autowired
    private ITaskInfoDao taskInfoDao;

    @Override
    public Page<TaskInfo> listByPage(int pageNumber, int pageSize) {
        Page<TaskInfo> taskPage = new Page<>(pageNumber, pageSize);

        QueryWrapper<TaskInfo> queryWrapper = new QueryWrapper<>();
        // 根据开始时间倒序排列
        queryWrapper.orderByDesc("create_time");
        taskInfoDao.page(taskPage, queryWrapper);

        return taskPage;
    }
}






