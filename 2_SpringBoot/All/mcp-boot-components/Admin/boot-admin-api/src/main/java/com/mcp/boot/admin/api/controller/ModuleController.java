package com.mcp.boot.admin.api.controller;

import com.mcp.boot.admin.domain.models.dto.PageData;
import com.mcp.boot.admin.domain.service.IModuleService;
import com.mcp.boot.admin.infrastructure.api.ResponseResult;
import com.mcp.boot.admin.infrastructure.entity.ModuleInfo;
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
@Api(tags = "模块")
@RestController
@RequestMapping("/modules")
@ResponseResult
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @ApiOperation(value = "分页显示模块")
    @ResponseBody
    @GetMapping(value = "")
    public PageData<ModuleInfo> listCodesByPage(@RequestParam(name = "pageNumber") int pageNumber, @RequestParam(name = "pageSize") int pageSize) {
        return moduleService.showTasksByPage(pageNumber, pageSize);
    }
}
