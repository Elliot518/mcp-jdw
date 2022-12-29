package com.mcp.boot.admin.infrastructure.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.boot.admin.infrastructure.dao.ICategoryDao;
import com.mcp.boot.admin.infrastructure.entity.Category;
import com.mcp.boot.admin.infrastructure.mapper.CategoryMapper;
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
public class CategoryDaoImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryDao {}