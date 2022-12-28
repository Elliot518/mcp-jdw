package com.mcp.demo.crypto.encrypt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author: KG
 * @description:
 * @date: Created in 20:47 2022/4/29
 * @modified by:
 */
@Slf4j
public class EncryptDemo {
    public static void main(String[] args) {
        // 待加密字符串
        String str = "abcd1234567890efghijklmn";
        // 1、MD5加密
        String md5Str = DigestUtils.md5Hex(str);
        log.info("MD5-->{}", md5Str);

        // SHA1加密
        String sha1Str = DigestUtils.sha1Hex(str);
        log.info("SHA1-->{}", sha1Str);

        // SHA256加密
        String sha256Str = DigestUtils.sha256Hex(str);
        log.info("SHA256-->{}", sha256Str);

        // SHA512加密
        String sha512Str = DigestUtils.sha512Hex(str);
        log.info("SHA512-->{}", sha512Str);

        // Base64加密
        String base64Str = Base64.encodeBase64String(str.getBytes());
        log.info("base64加密-->{}", base64Str);

        // Base64解密
        String base64DecodeStr = new String(Base64.decodeBase64(base64Str));
        log.info("base64解密-->{}", base64DecodeStr);
    }
}
