package com.myproject.config;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

import com.myproject.interceptor.WebFilter;
import com.myproject.servlet.InitServlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
      // 모든 uri에 대해 http://localhost:18080, http://localhost:8180 도메인은 접근을 허용한다.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081","http://localhost:8082");
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
    
    /**
     * WebFilter Add
     * @return
     */
    @Bean 
    public FilterRegistrationBean<Filter> getFilterRegistrationBean() { 
      FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(new WebFilter());
      registrationBean.addUrlPatterns("/api/*"); 

      //로그인 외 인증 토큰 체크

      return registrationBean;
    }  
}