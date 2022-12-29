package com.mcp.boot.admin.infrastructure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author: KG
 * @description: 文件增强工具类
 * @date: Created in 22:01 2022/4/19
 * @modified by:
 */
@Slf4j
public class FilePlusUtils {
    /**
     * @param file 文件
     * @return java.lang.String
     * @author KG
     * @date 2022/4/19 19:19
     */
    public static String readFile(File file) {
        String line = "";
        StringBuffer content = new StringBuffer();

        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(in);
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception ex) {
            log.error("Read file error: ", ex);
        }

        return content.toString();
    }

    public static String readByStream(InputStream stream) {
        String line = "";
        StringBuffer content = new StringBuffer();

        try (InputStreamReader in = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(in);
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (Exception ex) {
            log.error("Read stream error: ", ex);
        }

        return content.toString();
    }
}





