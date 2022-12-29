package com.mcp.ddd.skeleton.domain.exception;

import com.mcp.infrastructure.common.domain.exception.ApiException;

/**
 * @author KG
 * @description 业务自定义异常
 * @date Created in 2021年08月19日 2:54 PM
 * @modified_by
 */
public class BusinessException extends ApiException {
    public BusinessException(BusinessResultCode resultCode) {
        super(resultCode.getCode(), resultCode.getMessage());
    }

    public BusinessException(String code, String message) {
        super(code, message);
    }
}


