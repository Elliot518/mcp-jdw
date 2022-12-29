package com.mcp.ddd.skeleton.domain.exception;

import com.mcp.infrastructure.common.domain.api.IErrorCode;

/**
 * @author KG
 * @description 业务状态码和信息
 * @date Created in 2021年08月19日 2:55 PM
 * @modified_by
 */
public enum BusinessResultCode implements IErrorCode {
    /**
     * 上传创建文件错误码
     * @author KG
     * @date 2021/8/19 3:00 PM
     */
    UPLOAD_FILE_EXCEED_LIMIT("2000", "上传文件大小超出限制"),
    UPLOAD_CREATE_FILE_ERROR("2001", "上传创建文件错误"),
    READ_DOC_FILE_ERROR("2002", "读取doc文件错误"),
    READ_DOCX_FILE_ERROR("2003", "读取docx文件错误"),
    READ_WORD_FILE_FORMAT_ERROR("2004", "此文件不是word文件"),
    SAVE_BATCH_ANALYZED_CONTENTS_FAIL("2005", "批量保存解析内容失败"),

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

