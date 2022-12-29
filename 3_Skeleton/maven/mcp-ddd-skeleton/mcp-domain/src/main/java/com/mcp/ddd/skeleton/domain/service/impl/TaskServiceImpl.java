package com.mcp.ddd.skeleton.domain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mcp.ddd.skeleton.domain.repository.ITaskInfoRepository;
import com.mcp.ddd.skeleton.domain.service.ITaskService;
import com.mcp.ddd.skeleton.infra.entity.TaskInfo;
import com.mcp.infrastructure.common.domain.data.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午9:02 2022/4/7
 * @modified by:
 */

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskInfoRepository taskInfoRepository;

    @Override
    public PageData<TaskInfo> showTasksByPage(int pageNumber, int pageSize) {


        IPage<TaskInfo> taskPage = taskInfoRepository.listByPage(pageNumber, pageSize);

        List<TaskInfo> dataList = taskPage.getRecords();
        if (CollectionUtils.isEmpty(dataList)) {
            return convertToPageData(0, 1, Collections.emptyList());
        }

        return convertToPageData(taskPage.getTotal(), pageNumber, dataList);
    }

    private PageData<TaskInfo> convertToPageData(long total, int current, List<TaskInfo> data) {
        PageData<TaskInfo> pageData = new PageData<>();

        pageData.setTotalCount(total);
        pageData.setCurrentPage(current);
        pageData.setData(data);

        return pageData;
    }
}
