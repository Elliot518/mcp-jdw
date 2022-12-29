package com.mcp.boot.admin.infrastructure.constant;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:32 2022/4/14
 * @modified by:
 */
public enum ResultStatus implements IStatusCode {

    /* 成功 */
    SUCCESS(0, "成功"),

    /* 失败 */
    FAIL(1, "失败");

    private final int id;
    private final String status;

    private ResultStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public static String match(int code) {
        return StatusHelper.match(code, ResultStatus.values());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getStatus() {
        return status;
    }
}

