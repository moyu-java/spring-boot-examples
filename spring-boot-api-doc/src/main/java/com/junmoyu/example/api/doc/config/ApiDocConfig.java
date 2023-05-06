package com.junmoyu.example.api.doc.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * 接口文档配置
 *
 * @author 莫语
 * @date 2023/4/21
 */
@Configuration
@AutoConfigureBefore(SpringDocConfiguration.class)
public class ApiDocConfig {
    private static final String TOKEN_HEADER = "Authorization";

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(TOKEN_HEADER, new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                        .addParameters(TOKEN_HEADER, new Parameter()
                                .in("header")
                                .schema(new StringSchema())
                                .name("token")))
                .info(new Info()
                        .title("接口文档")
                        .description("Spring Boot Api Doc")
                        .version("0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Full Documentation")
                        .url("https://springdoc.org"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("decathlon")
                .pathsToMatch("/**")
                // 添加自定义配置，这里添加了一个用户认证的 header，否则 knife4j 里会没有 header
                .addOperationCustomizer((operation, handlerMethod) -> operation.security(Collections.singletonList(new SecurityRequirement().addList(TOKEN_HEADER))))
                .build();
    }
}
