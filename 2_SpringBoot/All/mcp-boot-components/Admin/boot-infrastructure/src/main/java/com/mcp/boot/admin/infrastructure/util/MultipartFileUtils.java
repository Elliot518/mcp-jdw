package com.mcp.boot.admin.infrastructure.util;

import com.mcp.boot.admin.infrastructure.api.IErrorCode;
import com.mcp.boot.admin.infrastructure.exception.ApiException;
import com.mcp.boot.admin.infrastructure.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:28 2022/4/9
 * @modified by:
 */
@Slf4j
public class MultipartFileUtils {
    /**
     * 上传文件
     *
     * @param baseFolder 根路径
     * @param file       文件
     * @return java.lang.String 文件名
     * @author KG
     * @date 2022/4/9 下午5:30
     */
    public static String uploadFile(String baseFolder, MultipartFile file, IErrorCode errorCode) {
        // 服务器上的文件名
        String filename = format(Objects.requireNonNull(file.getOriginalFilename()));

        //String path = System.getProperty("user.dir") + UPLOAD_FOLDER + filename;  //linux不能用\\
        String path = baseFolder + filename;
        log.info("upload path:" + path);

        File newFile = new File(path);

        try {
            // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
        } catch (IOException e) {
            log.error("Upload file exception: ", e);
            throw new ApiException(errorCode);
        }

        // return file url
        return filename;
    }

    private static String format(String oldFilename) {
        String[] str = oldFilename.split("\\.");

        return IdGenerator.getUid() + "." + str[1];
    }
}




