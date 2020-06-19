package com.myproject.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
public class InitServlet extends HttpServlet{

    private static final long serialVersionUID = 1017912981378652106L;
    private static final Logger logger = LogManager.getLogger(InitServlet.class);

    @Override
    public void init(ServletConfig sc) {
        logger.info("Start Web Service ~~~~~~~~~~~~~");
    }

    @Override
    public void destroy() {
        // 종료
        logger.info("End Web Service ~~~~~~~~~~~~~");
    }

} 