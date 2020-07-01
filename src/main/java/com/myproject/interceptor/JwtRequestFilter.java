package com.myproject.interceptor;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.common.JwtConst;
import com.myproject.model.user.*;
import com.myproject.service.user.UserService;
import com.myproject.util.JwtTokenUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
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
@Component
public class JwtRequestFilter extends OncePerRequestFilter{
    private static final Logger logger = LogManager.getLogger(JwtRequestFilter.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader(JwtConst.HEADER_STRING);
        String userId = null;
        String jwtToken = null;
       
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        logger.info("Call Security Filter >>>> "+requestTokenHeader);
        // logger.info("TOKEN_PREFIX >> "+JwtConst.TOKEN_PREFIX+" ");
        // if(requestTokenHeader != null){
        //    logger.info(requestTokenHeader.startsWith(JwtConst.TOKEN_PREFIX+"")); 
        // }
        if (requestTokenHeader != null && requestTokenHeader.startsWith(JwtConst.TOKEN_PREFIX)) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                userId = jwtTokenUtil.getUsernameFromToken(jwtToken);
                logger.info("userId >>>>"+userId);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                logger.error("JWT Token has expired");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
            
        }

        // if(request.getAttribute("userId") != null){
            logger.info(request.getQueryString());
            logger.info(SecurityContextHolder.getContext().getAuthentication() + " >>> userId : "+ userId);
        // }
        // Once we get the token validate it.
        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserVO userDetails = this.userService.findByUserId(userId);
                // if token is valid configure Spring Security to manually set
                // authentication
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}