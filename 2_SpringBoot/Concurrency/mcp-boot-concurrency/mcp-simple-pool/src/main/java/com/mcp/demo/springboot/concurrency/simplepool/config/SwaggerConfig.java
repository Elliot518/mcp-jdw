package com.mcp.demo.springboot.concurrency.simplepool.config;

import com.mcp.infrastructure.common.domain.config.AbstractSwaggerConfig;
import com.mcp.infrastructure.common.domain.config.SwaggerApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author KG
 * @description
 * @date Created in 2021年09月25日 7:39 PM
 * @modified_by
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {
    @Override
    protected SwaggerApiInfo getApiInfo() {
        SwaggerApiInfo swaggerApiInfo = new SwaggerApiInfo();
        swaggerApiInfo.setBasePackage("com.mcp.demo.springboot.concurrency.simplepool.controller");
        swaggerApiInfo.setTitle("mcp-simple-pool API");
        swaggerApiInfo.setDescription("swagger-ui API for mcp-simple-pool");
        swaggerApiInfo.setServiceUrl("http://www.microcomponent.net");
        swaggerApiInfo.setVersion("1.0");

        return swaggerApiInfo;
    }

    @Bean
    @Override
    public Docket createRestApi() {
        return super.createRestApi();
    }
}