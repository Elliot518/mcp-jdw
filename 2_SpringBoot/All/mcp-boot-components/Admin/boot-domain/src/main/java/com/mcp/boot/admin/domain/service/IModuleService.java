package com.mcp.boot.admin.domain.service;

import com.mcp.boot.admin.domain.models.dto.PageData;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;


/**
 * @author: KG
 * @description:
 * @date: Created in 下午9:00 2022/4/7
 * @modified by:
 */

public interface IModuleService {
    /**
     * show tasks by page
     * @author KG
     * @date 2022/4/7 下午9:01
     * @param pageNumber page number
     * @param pageSize page size
     * @return com.mcp.infrastructure.common.domain.data.PageData<com.mcp.boot.admin.infrastructure.entity.ModuleInfo>
     */
    PageData<ModuleInfo> showTasksByPage(int pageNumber, int pageSize);
}

