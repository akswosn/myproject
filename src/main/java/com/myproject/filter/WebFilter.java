package com.myproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
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
@Order(0)
public class WebFilter implements Filter { 
    private static final Logger logger = LogManager.getLogger(WebFilter.class);

    @Override 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{ 
        HttpServletRequest req = (HttpServletRequest)request;
        logger.info("Call Filter uri >>> "+req.getRequestURI());
        chain.doFilter(request, response);
    } 

    @Override
	public void destroy(){
	}

	@Override
	public void init(FilterConfig fc) throws ServletException{
        System.out.println(">>>>>>>>>>>>>>>>>> init Filter");
	}
}

