package com.zhou.code.handler;

public interface CryptSignHandler<T,R> {
    /**
     * 结果加密
     * @param data
     * @return
     */
    String encrypt(Object data);

    /**
     * 请求解密
     * @param data
     * @return
     */
    String decrypt(String data);

    /**
     * 校验请求签名
     * @return
     */
    void checkSign(T req);

    /**
     * 结果生成签名
     * @param res
     * @return
     */
    String sign(R res);
}
