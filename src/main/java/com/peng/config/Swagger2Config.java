package com.peng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author pengcq 412940226@qq.com	
 * @date 2017年8月3日 上午12:01:58
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages={"com.peng.web.controller"})
@EnableWebMvc
public class Swagger2Config extends WebMvcConfigurationSupport{
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
//				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.peng.web.controller"))
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful APIS")
				.description("Hello Swagger2")
				.contact("pengyu")
				.version("1.0")
				.build();
	}
	
}
