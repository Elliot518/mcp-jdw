package com.mcp.demo.springboot.concurrency.simplepool.exception;

import com.mcp.infrastructure.common.domain.api.IErrorCode;

/**
 * @author KG
 * @description 业务状态码和信息
 * @date Created in 2021年08月19日 2:55 PM
 * @modified_by
 */
public enum BusinessResultCode implements IErrorCode {
    /**
     * 异常码
     */
    THREAD_EXECUTE_ERROR("8000", "线程执行异常"),

    DB_OPERATION_ERROR("9990", "数据库操作异常");

    private String code;
    private String message;

    private BusinessResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}




