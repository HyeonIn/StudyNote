package com.ssafy.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private ApiInfo info() {
		return new ApiInfoBuilder().title("Rest로 만드는 게시판").build();
	}
	
	@Bean //xml에서 사용되던 <bean> 태그 역할
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(info())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.rest.controller"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}
	
}
