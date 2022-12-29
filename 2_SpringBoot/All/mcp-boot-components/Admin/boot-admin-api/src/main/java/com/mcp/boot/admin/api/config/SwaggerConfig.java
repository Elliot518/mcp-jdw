package com.mcp.boot.admin.api.config;

import com.mcp.boot.admin.infrastructure.config.AbstractSwaggerConfig;
import com.mcp.boot.admin.infrastructure.config.SwaggerApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:16 下午 2020/11/2
 * @modified by:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {
    @Override
    protected SwaggerApiInfo getApiInfo() {
        SwaggerApiInfo swaggerApiInfo = new SwaggerApiInfo();
        swaggerApiInfo.setBasePackage("com.mcp.boot.admin.api.controller");
        swaggerApiInfo.setTitle("boot-admin-api API");
        swaggerApiInfo.setDescription("swagger-ui API for boot-admin-api");
        swaggerApiInfo.setServiceUrl("http://www.microcomponent.net");
        swaggerApiInfo.setVersion("1.0");
        //swaggerApiInfo.setTokenHead(SwaggerConstant.TOKEN_HEAD);
        return swaggerApiInfo;
    }

    @Bean
    @Override
    public Docket createRestApi() {
        return super.createRestApi();
    }
}
