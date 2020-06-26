package com.myproject.repository.test;

import java.util.Optional;

import com.myproject.model.test.TestVO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
* <pre>
* 간략 : 
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 18.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@Repository
public interface TestRepository extends JpaRepository<TestVO, Long>{


    public Optional<TestVO> findByNo(long no);

    
}

