package com.zhou.code.encrypt.algorithm;


import com.zhou.code.encrypt.utils.AesEncryptUtil;

/**
 * Aes加密算法实现
 */
public class AesEncryptAlgorithm implements EncryptAlgorithm {

    @Override
    public String encrypt(String content, String encryptKey) throws Exception {
        return AesEncryptUtil.aesEncrypt(content, encryptKey);
    }

    @Override
    public String decrypt(String encryptStr, String decryptKey) throws Exception {
        return AesEncryptUtil.aesDecrypt(encryptStr, decryptKey);
    }

}
