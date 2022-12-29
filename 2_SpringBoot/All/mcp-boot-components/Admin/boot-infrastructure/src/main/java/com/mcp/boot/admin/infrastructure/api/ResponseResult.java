package com.mcp.boot.admin.infrastructure.api;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @author: KG
 * @description: Unified Json Format Annotation
 * @date: Created in 10:33 上午 2020/11/3
 * @modified by:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResult {
}
