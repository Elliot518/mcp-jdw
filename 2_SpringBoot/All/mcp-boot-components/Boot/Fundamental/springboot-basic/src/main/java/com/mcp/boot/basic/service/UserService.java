package com.mcp.boot.basic.service;

import com.mcp.boot.basic.dto.AddUserParamsDto;

import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:54 2022/6/8
 * @modified by:
 */
public interface UserService {
    void validByService(AddUserParamsDto dto);

    void validListByService(List<AddUserParamsDto> dtoList);
}
