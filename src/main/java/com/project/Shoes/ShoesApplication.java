package com.project.Shoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
public class ShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoesApplication.class, args);
	}

    @Configuration
    @EnableSwagger2
    public static class SwaggerConfig {

        @Bean
        public Docket apiDocket() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.project.Shoes.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(getApiInfo())
                    ;
        }

        private ApiInfo getApiInfo() {
            return new ApiInfo(
                    "MardelShoes API",
                    "MardelShoes API Description",
                    "1.0",
                    "http://MardelShoes.com/terms",
                    new Contact("GL", "https://GL.com", "mardelShoes@GL.com"),
                    "LICENSE",
                    "LICENSE URL",
                    Collections.emptyList()
            );
        }
    }
}
