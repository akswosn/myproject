package com.myproject.service.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myproject.model.test.TestVO;
import com.myproject.repository.test.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class TestService {
    @Autowired
    private TestRepository testRepo;

    public List<TestVO> findAll()  {
        List<TestVO> result = new ArrayList<>();
        testRepo.findAll().forEach(e -> result.add(e));
        return result;
    }

    public Optional<TestVO>  findByNo(long no)  {
        Optional<TestVO> result = testRepo.findByNo(no); 
        return result;
    }

    public void update(Long no, TestVO testVO)  {
        Optional<TestVO> e = testRepo.findByNo(no);

        if (e.isPresent()) {  
            e.get().setName(testVO.getName()); 
            e.get().setContents(testVO.getContents());
            e.get().setUdate(LocalDateTime.now());
            testRepo.save(e.get()); 
        }
    }

    public TestVO save(TestVO vo) {
        vo.setRdate(LocalDateTime.now());
        vo.setUdate(LocalDateTime.now());
        testRepo.save(vo);
        return vo;
    }

    public void deleteByNo(long no) {
        testRepo.deleteById(no);
    }
}