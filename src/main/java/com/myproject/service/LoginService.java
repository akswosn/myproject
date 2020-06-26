package com.myproject.service;

import com.myproject.model.UserVO;
import com.myproject.model.WebSessionVO;
import com.myproject.repository.UserRepository;
import com.myproject.repository.WebSessionRepository;
import com.myproject.util.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
* <pre>
* 간략 : 
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 23.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSessionRepository webSessionRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
  

	public WebSessionVO login(UserVO param) {
        authenticate(param.getUser_id(), param.getUser_pwd());
        final UserVO userDetails = userRepository.loadUserByUsername(param.getUser_id());
        final String token = jwtTokenUtil.generateToken(userDetails);

        //return ResponseEntity.ok(new JwtResponse(token));


        return null;
    }    

    public boolean isLoginTokken(String token){
        boolean result = false;
        //webSessionRepository.findOne(ExampleMatcher.matching());
        return result;
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}