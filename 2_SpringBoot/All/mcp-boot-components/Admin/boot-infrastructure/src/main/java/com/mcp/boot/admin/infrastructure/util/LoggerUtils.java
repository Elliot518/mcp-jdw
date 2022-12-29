package com.mcp.boot.admin.infrastructure.util;

import com.mcp.boot.admin.infrastructure.log.ILogFileName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: KG
 * @description:
 * @date: Created in 19:44 2022/4/20
 * @modified by:
 */
public class LoggerUtils {
    public static <T> Logger Logger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static Logger Logger(ILogFileName desc) {
        return LoggerFactory.getLogger(desc.getLogFileName());
    }
}
