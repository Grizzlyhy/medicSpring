package com.zhou.code.encrypt.utils;




import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName AesEncryptUtil
 * @Description //AES加密解密工具
 * @Author singleZhang
 * @Email 405780096@qq.com
 * @Date 2021/1/7 0007 下午 3:28
 **/
public class AesEncryptUtil {
    private static final String KEY = "d7b85f6e214abcda";
    private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64Decode(String base64Code) throws Exception {
        return Base64.decodeBase64(base64Code);
    }

    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        return cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
    }

    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes, StandardCharsets.UTF_8);
    }

    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

// TODO TEST

    public static void main(String[] args) throws Exception {
        String content = "SingleZhang2021";
        System.out.println("加密前：" + content);

        String encrypt = "kxisBnVJcjl/IGJm+MHREEys/Myd31N7X/dM5jhX4NUNurFg/X+3dca/ATP7fApN";
        System.out.println(encrypt.length() + ":加密后：" + encrypt);

        String decrypt = aesDecrypt(encrypt, KEY);
        System.out.println("解密后：" + decrypt);
    }
}
