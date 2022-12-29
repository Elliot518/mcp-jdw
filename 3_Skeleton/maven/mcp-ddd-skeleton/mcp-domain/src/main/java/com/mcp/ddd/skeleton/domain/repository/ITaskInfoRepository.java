package com.mcp.ddd.skeleton.domain.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcp.ddd.skeleton.infra.entity.TaskInfo;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午8:21 2022/4/7
 * @modified by:
 */

public interface ITaskInfoRepository {
    /**
     * List task info by page
     * @author KG
     * @date 2022/4/7 下午8:58
     * @param pageNumber
     * @param pageSize
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.mcp.ddd.skeleton.infra.entity.TaskInfo>
     */
    Page<TaskInfo> listByPage(int pageNumber, int pageSize);
}

