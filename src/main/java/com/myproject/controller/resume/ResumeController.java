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
import org.springframework.web.bind.annotation.PostMapping;
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
* @Version : 1.0 (v1)s
* -----------------------------------
* 1.0 : 신규작성
*/
@RestController
@RequestMapping("v1/api/resume")
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
            resp = MyResponseEntity.success(data);
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }



        return resp;
    }

    @PostMapping
    public MyResponseEntity<ResumeVO> save(@RequestBody ResumeVO resume){
        logger.debug("resume save param >>> "+resume);
        MyResponseEntity<ResumeVO> resp = new MyResponseEntity<>();
        try {
            ResumeVO vo = resumeService.save(resume);
            logger.debug("save result >>> "+vo);

            resp = MyResponseEntity.success(vo);
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }


        return resp;
    }
}