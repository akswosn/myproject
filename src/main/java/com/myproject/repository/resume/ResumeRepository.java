package com.myproject.repository.resume;

import org.springframework.stereotype.Repository;

import com.myproject.model.resume.ResumeVO;

import org.springframework.data.jpa.repository.JpaRepository;
/**
* <pre>
* 간략 : 
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 7. 01.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@Repository
public interface ResumeRepository extends JpaRepository<ResumeVO, Long>{

    
    
}