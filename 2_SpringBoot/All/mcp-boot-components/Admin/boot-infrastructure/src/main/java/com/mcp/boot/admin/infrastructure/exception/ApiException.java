package com.mcp.boot.admin.infrastructure.exception;

import com.mcp.boot.admin.infrastructure.api.IErrorCode;
import com.mcp.boot.admin.infrastructure.api.ResultCode;
import lombok.Getter;

/**
 * @author: KG
 * @description: 自定义接口异常
 * @date: Created in 5:41 下午 2020/8/5
 * @modified by:
 */
@Getter
public class ApiException extends RuntimeException {
    protected String code;
    protected String msg;

    public ApiException() {
        this(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMessage());
    }

    public ApiException(String msg) {
        this(ResultCode.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(IErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }
}
