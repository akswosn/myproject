package com.myproject.config;

import java.util.ArrayList;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.myproject.controller"))
            .paths(PathSelectors.any()).build()
            .useDefaultResponseMessages(true);
                
                                        
    }
    
    

	private ApiInfo apiInfo() {
        return new ApiInfo("My Project(MyBlog)"
                , "My Blog Swagger API Document"
                , "v1"
                , "http:////3.133.151.227"
                , new Contact("Lim Keun-su", "http:////3.133.151.227", "akswosn@gmail.com")
                , null, null, new ArrayList<>());
 
    }
}