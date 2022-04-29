package com.zhou.code.encrypt.autoconfigure;


import com.zhou.code.encrypt.algorithm.EncryptAlgorithm;
import com.zhou.code.encrypt.core.EncryptionConfig;
import com.zhou.code.encrypt.init.ApiEncryptDataInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 加解密自动配置
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(EncryptionConfig.class)
public class EncryptAutoConfiguration {

    @Autowired
    private EncryptionConfig encryptionConfig;

    @Autowired(required = false)
    private EncryptAlgorithm encryptAlgorithm;


    @Bean
    public ApiEncryptDataInit apiEncryptDataInit() {
        return new ApiEncryptDataInit();
    }
}
