package com.myproject.repository.user;

import java.util.Optional;

import com.myproject.model.user.UserVO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
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
@Repository
public interface UserRepository extends JpaRepository<UserVO, Long>{

    public Optional<UserVO> findByUserId(String user_id); 

    @Query(value = "SELECT u FROM tb_user u WHERE user_id = :userId and user_pwd = password(:userPwd)")
    public UserVO loginUserCheck(String userId, String userPwd);
}