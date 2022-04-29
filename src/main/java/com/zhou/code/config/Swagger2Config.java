package com.zhou.code.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//可以省去
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo()).enable(true)
                .select()
                .build();
    }
    //自定义项目文档内容
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                //文档标题
                .title("API文档")
                //文档描述
                .description("管理系统")
                //文档版本
                .version("1.0")
                //作者及联系方式
                .contact(new Contact("xxx", "", "1234@qq.com"))
                .build();
    }
}


