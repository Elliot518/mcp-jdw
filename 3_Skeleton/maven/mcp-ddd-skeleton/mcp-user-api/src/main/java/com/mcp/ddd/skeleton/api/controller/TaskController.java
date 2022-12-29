package com.mcp.ddd.skeleton.api.controller;

import com.mcp.ddd.skeleton.domain.service.ITaskService;
import com.mcp.ddd.skeleton.infra.entity.TaskInfo;
import com.mcp.infrastructure.common.domain.api.ResponseResult;
import com.mcp.infrastructure.common.domain.data.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午9:12 2022/4/7
 * @modified by:
 */
@Slf4j
@Api(tags = "任务")
@RestController
@RequestMapping("/tasks")
@ResponseResult
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @ApiOperation(value = "分页显示代码产品")
    @ResponseBody
    @GetMapping(value = "")
    public PageData<TaskInfo> listCodesByPage(@RequestParam(name = "pageNumber") int pageNumber, @RequestParam(name = "pageSize") int pageSize) {
        return taskService.showTasksByPage(pageNumber, pageSize);
    }
}
