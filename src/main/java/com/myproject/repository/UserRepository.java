package com.myproject.repository;

import com.myproject.model.UserVO;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface UserRepository extends JpaRepository<UserVO, Long>{
    
}