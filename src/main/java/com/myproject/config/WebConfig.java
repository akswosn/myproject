package com.myproject.config;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

import com.myproject.interceptor.WebFilter;
import com.myproject.servlet.InitServlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class WebConfig {

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
		return registrationBean;
    }  
}