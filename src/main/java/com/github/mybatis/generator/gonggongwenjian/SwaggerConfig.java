package com.github.mybatis.generator.gonggongwenjian;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 文档
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private Boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                /*.securityContexts(securityContexts())
                .securitySchemes(securitySchemes())*/;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dms接口文档")
                .description("接口文档")
                .version("1.0")
                .build();
    }

/*
    private List<ApiKey> securitySchemes() {
        ApiKey tokenHeader = new ApiKey(RequestHeadConstant.DMS_NAME_TOKEN, RequestHeadConstant.DMS_NAME_TOKEN, "header");
        ApiKey userHeader = new ApiKey(RequestHeadConstant.DMS_NAME_USER, RequestHeadConstant.DMS_NAME_USER, "header");
        return Lists.newArrayList(tokenHeader, userHeader);
    }

    private List<SecurityContext> securityContexts() {
        SecurityContext context = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
        return Lists.newArrayList(context);
    }

    private List<SecurityReference> defaultAuth() {

        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        SecurityReference token = new SecurityReference(RequestHeadConstant.DMS_NAME_TOKEN, authorizationScopes);
        SecurityReference username = new SecurityReference(RequestHeadConstant.DMS_NAME_USER, authorizationScopes);
        return Lists.newArrayList(token,username);
    }*/
}