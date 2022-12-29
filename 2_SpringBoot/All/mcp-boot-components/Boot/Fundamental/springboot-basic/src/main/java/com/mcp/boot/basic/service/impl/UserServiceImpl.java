package com.mcp.boot.basic.service.impl;

import com.mcp.boot.basic.dto.AddUserParamsDto;
import com.mcp.boot.basic.service.UserService;
import com.mcp.infrastructure.common.domain.exception.ApiException;
import com.mcp.infrastructure.common.domain.exception.BaseErrorCodeEnum;
import com.mcp.infrastructure.common.domain.exception.BaseResultCode;
import com.mcp.infrastructure.common.domain.exception.ParamException;
import com.mcp.infrastructure.common.domain.helper.ParamHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:55 2022/6/8
 * @modified by:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private Validator validator;

    @Override
    public void validByService(AddUserParamsDto dto) {
        ParamHelper.validateParams(validator, dto);
    }

    @Override
    public void validListByService(List<AddUserParamsDto> dtoList) {
        ParamHelper.validateParamsList(validator, dtoList);
    }
}


