package com.mcp.boot.admin.infrastructure.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: KG
 * @description: 文件检查工具
 * @date: Created in 下午7:21 2022/4/9
 * @modified by:
 */
@Slf4j
public class FileCheckUtils {

    private static final String UNIT_B = "B";
    private static final String UNIT_K = "K";
    private static final String UNIT_M = "M";
    private static final String UNIT_G = "G";

    /**
     * 判断文件大小限制
     * @author KG
     * @date 2022/4/9 下午7:22
     * @param len 文件长度
     * @param size 限制大小
     * @param unit 限制单位(B,K,M,G)
     * @return boolean
     */
    public static boolean checkFileSizeLimit(Long len, int size, String unit) {
        double fileSize = 0;

        if (UNIT_B.equalsIgnoreCase(unit)) {
            fileSize = len;
            log.info("***check file size: {} B", fileSize);
        } else if (UNIT_K.equalsIgnoreCase(unit)) {
            fileSize = (double) len / 1024;
            log.info("***check file size: {} K", fileSize);
        } else if (UNIT_M.equalsIgnoreCase(unit)) {
            fileSize = (double) len / 1048576;
            log.info("***check file size: {} M", fileSize);
        } else if (UNIT_G.equalsIgnoreCase(unit)) {
            fileSize = (double) len / 1073741824;
            log.info("***check file size: {} G", fileSize);
        }

        return fileSize <= size;
    }
}
