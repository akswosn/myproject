package com.myproject.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.myproject.model.WebSessionVO;
import com.myproject.model.user.UserVO;
import com.myproject.repository.WebSessionRepository;
import com.myproject.repository.user.UserRepository;
import com.myproject.util.JwtTokenUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
    private final Logger logger = LogManager.getLogger(LoginService.class);
    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private WebSessionRepository webSessionRepository;

    @Autowired
    private UserRepository userRepo;


    public WebSessionVO login(UserVO vo){
        WebSessionVO result = new WebSessionVO();
        // UserDetails userDetails = loadUserByUsername(vo.getUserId());
        // logger.info("userDetails >>>>>>>>>>>"+userDetails);

        String token = tokenUtil.generateToken(vo);
        logger.info("token >>>>>>>>>>>>>> "+token);
        result.setUserNo(vo.getNo());
        result.setSessionKey(token);
        WebSessionVO check = webSessionRepository.findByUserNo(result.getUserNo());
        logger.info("WebSessionVO >>> "+check);

        if(check != null){
            webSessionRepository.deleteById(check.getNo());
        }
        result.setLoginTime(LocalDateTime.now());
        webSessionRepository.save(result);

        return result;
    }

    public WebSessionVO hasLogin(WebSessionVO param){
        Optional<WebSessionVO> vo = webSessionRepository.findByUserNoAndSessionKey(param.getUserNo(), param.getSessionKey());
        if(vo != null){
            return vo.get();
        } 
        else {
            return null;
        }

    }


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        /*Here we are using dummy data, you need to load user data from
        database or other third party application*/
        Optional<UserVO> userOp = userRepo.findByUserId(userId);
        UserDetails userDetails = null;
        if (userOp.get() != null) {
            logger.info("loadUserByUsername >>>> vo "+ userOp.get());
            UserVO user = userOp.get();
            userDetails = User.builder().username(String.valueOf(user.getUserId())).password(user.getUserPwd()).build();

            // builder = User.withUsername(userId);
            // builder.password(new BCryptPasswordEncoder().encode(user.getUserPwd()));


            // builder.roles(user.getRoll());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return userDetails;
    }
}