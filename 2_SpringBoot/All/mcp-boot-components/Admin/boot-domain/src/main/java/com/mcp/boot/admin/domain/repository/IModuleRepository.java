package com.mcp.boot.admin.domain.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午8:21 2022/4/7
 * @modified by:
 */

public interface IModuleRepository {
    /**
     * List task info by page
     * @author KG
     * @date 2022/4/7 下午8:58
     * @param pageNumber
     * @param pageSize
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.mcp.boot.admin.infrastructure.entity.ModuleInfo>
     */
    Page<ModuleInfo> listByPage(int pageNumber, int pageSize);
}

