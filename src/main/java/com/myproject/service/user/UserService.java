package com.myproject.service.user;

import java.util.Optional;

import com.myproject.model.user.LoginParam;
import com.myproject.model.user.UserVO;
import com.myproject.repository.user.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  private final Logger logger = LogManager.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepo;

  public UserVO findByUserId(String userId) {
      Optional<UserVO> user = userRepo.findByUserId(userId);
      return user.get();
  }

  public UserVO loginUserCheck(LoginParam vo) {

      logger.info("Call loginUserCheck >>>");
      UserVO user = userRepo.loginUserCheck(vo.getUserId(), vo.getUserPwd());
      return user;
  }  
}