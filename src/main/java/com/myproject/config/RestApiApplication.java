package com.myproject.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
* <pre>
* 간략 : Web Filter, Servlet 등록 빈
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 18.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@SpringBootApplication
@ComponentScan("com.myproject")
@EnableJpaRepositories("com.myproject.repository")
@EntityScan("com.myproject.model")
public class RestApiApplication extends SpringBootServletInitializer  {
    
    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(RestApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

}


