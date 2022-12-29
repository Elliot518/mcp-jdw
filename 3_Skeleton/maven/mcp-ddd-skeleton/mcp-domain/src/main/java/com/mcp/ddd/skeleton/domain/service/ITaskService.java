package com.mcp.ddd.skeleton.domain.service;

import com.mcp.ddd.skeleton.infra.entity.TaskInfo;
import com.mcp.infrastructure.common.domain.data.PageData;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午9:00 2022/4/7
 * @modified by:
 */

public interface ITaskService {
    /**
     * show tasks by page
     * @author KG
     * @date 2022/4/7 下午9:01
     * @param pageNumber page number
     * @param pageSize page size
     * @return com.mcp.infrastructure.common.domain.data.PageData<com.mcp.ddd.skeleton.infra.entity.TaskInfo>
     */
    PageData<TaskInfo> showTasksByPage(int pageNumber, int pageSize);
}

