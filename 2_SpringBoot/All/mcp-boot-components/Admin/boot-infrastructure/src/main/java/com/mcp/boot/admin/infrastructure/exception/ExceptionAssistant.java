package com.mcp.boot.admin.infrastructure.exception;

import com.mcp.boot.admin.infrastructure.api.Result;
import com.mcp.boot.admin.infrastructure.api.ResultCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: KG
 * @description: 全局异常助手
 * @date: Created in 1:39 下午 2020/8/11
 * @modified by:
 */
@Slf4j
public class ExceptionAssistant {
    public static Result<String> captureApiException(Exception e) {
        if (e instanceof ApiException) {
            ApiException ex = (ApiException) e;
            String exceptInfo = LogFormat.apiErrorDetail(ex);
            log.error(exceptInfo);

            return Result.failure(ex.getCode(), ex.getMsg(), ex.getMessage());
        }

        log.error("********* 全局异常信息捕获: ", e);

        return Result.failure(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMessage(), e.getMessage());
    }

    public static Result<String> captureParamError(String cause) {
        return Result.failure(ResultCode.PARAM_INVALID.getCode(), ResultCode.PARAM_INVALID.getMessage(), cause);
    }
}
