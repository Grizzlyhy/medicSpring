package com.zhou.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.zhou.code.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CodegenerateApplication {
        public static void main(String[] args) {
            SpringApplication.run(CodegenerateApplication.class, args);


    }
}
