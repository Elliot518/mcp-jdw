package com.mcp.boot.admin.domain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mcp.boot.admin.domain.models.dto.PageData;
import com.mcp.boot.admin.domain.repository.IModuleRepository;
import com.mcp.boot.admin.domain.service.IModuleService;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;
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
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private IModuleRepository moduleRepository;

    @Override
    public PageData<ModuleInfo> showTasksByPage(int pageNumber, int pageSize) {


        IPage<ModuleInfo> modulePage = moduleRepository.listByPage(pageNumber, pageSize);

        List<ModuleInfo> dataList = modulePage.getRecords();
        if (CollectionUtils.isEmpty(dataList)) {
            return convertToPageData(0, 1, Collections.emptyList());
        }

        return convertToPageData(modulePage.getTotal(), pageNumber, dataList);
    }

    private PageData<ModuleInfo> convertToPageData(long total, int current, List<ModuleInfo> data) {
        PageData<ModuleInfo> pageData = new PageData<>();

        pageData.setTotalCount(total);
        pageData.setCurrentPage(current);
        pageData.setData(data);

        return pageData;
    }
}








