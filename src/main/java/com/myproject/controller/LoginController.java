package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.model.UserVO;
import com.myproject.model.WebSessionVO;
import com.myproject.service.LoginService;
import com.myproject.util.JwtTokenUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <pre>
* 간략 : 로그인 컨트롤러
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 23.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@RestController
@RequestMapping("api/login")
public class LoginController {
    
    private final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<WebSessionVO> login(@RequestBody UserVO param, HttpServletRequest request, HttpServletResponse response){
        logger.info("call login");
        WebSessionVO vo = new WebSessionVO();
        HttpStatus status = null;
        logger.info(param);
        try{
            //로그인 검증
            vo = loginService.login(param);
            
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
       

        return new ResponseEntity<WebSessionVO>(vo, status); 
    }
    

    
    
}