package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.model.WebSessionVO;
import com.myproject.model.common.MyResponseEntity;
import com.myproject.model.user.UserVO;
import com.myproject.service.LoginService;
import com.myproject.service.user.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
* @Version : 1.0 (v1)
* -----------------------------------
* 1.0 : 신규작성
*/
@RestController
@RequestMapping("v1/api/login")
public class LoginController {
    
    private final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping
    public MyResponseEntity<WebSessionVO> login(@RequestBody UserVO param, HttpServletRequest request, HttpServletResponse response){
        logger.info(">>>> call login");
        WebSessionVO vo = new WebSessionVO();
        MyResponseEntity<WebSessionVO> resp = new MyResponseEntity<>();
        logger.info(param);

        try{
            //로그인 검증
            //1. 사용자 검증
            UserVO userVO = userService.loginUserCheck(param);
            logger.info("userVO >>>>> "+userVO);

            if(userVO == null){
                resp.setCheck(false);
                resp.setCode(500);
                resp.setMessage("아이디/비밀번호를 확인해 주세요");
                return resp;
            }
            //2.토큰생성 및 로그인 처리
            vo = loginService.login(userVO);
            resp.setCheck(true);
            resp.setCode(200);
            resp.setData(vo);
            resp.setMessage("로그인 되었습니다.");
        }
        catch(Exception e){
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            resp.setCheck(false);
            resp.setCode(500);
            resp.setMessage(e.getMessage());

        }
   

        return resp;
    }   

    @PostMapping(value="/check")
    public MyResponseEntity<WebSessionVO> hasLogin(@RequestBody WebSessionVO param){
        MyResponseEntity<WebSessionVO> resp = new MyResponseEntity<>();
        try {
            WebSessionVO vo = loginService.hasLogin(param);
            if(vo == null){
                resp.setCheck(false);
                resp.setCode(500);
                resp.setData(null);
            }
            else {
                resp.setCheck(true);
                resp.setCode(200);
                resp.setData(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            resp.setCheck(false);
            resp.setCode(500);
            resp.setMessage(e.getMessage());

        }


        return resp;
    }
    
}