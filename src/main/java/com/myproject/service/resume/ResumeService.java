package com.myproject.service.resume;


import com.myproject.model.resume.ResumeVO;
import com.myproject.repository.resume.ResumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

	public Page<ResumeVO> getAll(PageRequest pageable) {
		return resumeRepository.findAll(pageable);
	}
    
}