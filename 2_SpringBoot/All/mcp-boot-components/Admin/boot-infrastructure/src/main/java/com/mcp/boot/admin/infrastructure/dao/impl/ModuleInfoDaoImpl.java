package com.mcp.boot.admin.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.boot.admin.infrastructure.dao.IModuleInfoDao;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;
import com.mcp.boot.admin.infrastructure.mapper.ModuleInfoMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KG
 * @since 2022-05-03
 */
@Repository
public class ModuleInfoDaoImpl extends ServiceImpl<ModuleInfoMapper, ModuleInfo> implements IModuleInfoDao {}