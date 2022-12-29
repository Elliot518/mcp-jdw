package com.mcp.boot.basic.vo;

import lombok.Data;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:50 2022/6/8
 * @modified by:
 */
@Data
public class UserReq {
    private String userName;

    private String phone;

    private String email;
}
