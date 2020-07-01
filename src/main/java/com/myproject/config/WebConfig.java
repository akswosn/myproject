package com.myproject.config;

import javax.servlet.http.HttpServlet;

import com.myproject.servlet.InitServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
        .allowedMethods("*");
    }

    
    /**
     * Init Servlet Add
     * @return
     */
    @Bean	
    public ServletRegistrationBean<HttpServlet> initServlet() {
      ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
      servRegBean.setServlet(new InitServlet());
      servRegBean.addUrlMappings("/init");
      servRegBean.setLoadOnStartup(2);
      servRegBean.setAsyncSupported(true);
      servRegBean.setName("InitServlet");

	   return servRegBean;
    }
    
   
}