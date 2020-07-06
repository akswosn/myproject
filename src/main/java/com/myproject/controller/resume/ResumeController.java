package com.myproject.controller.resume;

import java.util.List;

import com.myproject.model.common.CommonParam;
import com.myproject.model.common.MyResponseEntity;
import com.myproject.model.resume.ResumeVO;
import com.myproject.service.resume.ResumeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
* <pre>
* 간략 : 이력서 컨트롤러
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 23.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@RestController
@RequestMapping("api/resume")
public class ResumeController {

    private final Logger logger = LogManager.getLogger(ResumeController.class);

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public MyResponseEntity<Page<ResumeVO>> resumeList(@RequestParam(value="page") int page, @RequestParam(value="listCount") int listCount, @RequestParam(value="sort") String sort){
        MyResponseEntity<Page<ResumeVO>> resp = new MyResponseEntity<>();
        logger.info("resume list >>>> page="+page+", listCount="+listCount+", sort="+sort);
        try {
            Sort sortQuery = Sort.by(sort).descending();


            Page<ResumeVO> data = resumeService.getAll(PageRequest.of(page, listCount, sortQuery));
            logger.info("data >>> "+data);
            resp.setCheck(true);
            resp.setCode(200);
            resp.setData(data);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            resp.setCheck(false);
            resp.setCode(500);
            resp.setMessage(e.getMessage());
        }



        return resp;
    }
}