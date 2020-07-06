package com.myproject.repository;

import java.util.Optional;

import com.myproject.model.WebSessionVO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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
public interface WebSessionRepository extends JpaRepository<WebSessionVO, Long>{
    

    public WebSessionVO findByUserNo(@Param("user_no") long userNo);

	public Optional<WebSessionVO> findByUserNoAndSessionKey(@Param("user_no")long userNo, @Param("session_key")String sessionKey);


}