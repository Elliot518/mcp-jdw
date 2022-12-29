package com.mcp.boot.admin.domain.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcp.boot.admin.domain.repository.IModuleRepository;


import com.mcp.boot.admin.infrastructure.dao.IModuleInfoDao;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午8:33 2022/4/7
 * @modified by:
 */
@Repository
public class ModuleRepositoryImpl implements IModuleRepository {

    @Autowired
    private IModuleInfoDao moduleInfoDao;

    @Override
    public Page<ModuleInfo> listByPage(int pageNumber, int pageSize) {
        Page<ModuleInfo> modulePage = new Page<>(pageNumber, pageSize);

        QueryWrapper<ModuleInfo> queryWrapper = new QueryWrapper<>();
        // 根据开始时间倒序排列
        queryWrapper.orderByDesc("create_time");
        moduleInfoDao.page(modulePage, queryWrapper);

        return modulePage;
    }
}






