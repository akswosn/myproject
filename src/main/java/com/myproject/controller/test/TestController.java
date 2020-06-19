package com.myproject.controller.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.model.test.TestVO;
import com.myproject.service.test.TestService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
@RestController
@RequestMapping("api/test")
public class TestController {
    private final Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    private String[] IP_LIST = {"127.0.0.1", "211.62.247.33"};

    private boolean ipCheck(String ip){
        boolean result = Arrays.stream(IP_LIST).anyMatch(ip::equals);
        return result;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TestVO>> getAllTest() { 
        List<TestVO> result =null;
        HttpStatus status = null;
        try{
            logger.info("Call getAllTest");
            result = testService.findAll(); 
            status = HttpStatus.OK;
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<List<TestVO>>(result, status); 
    }

    @GetMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TestVO> getTestById(@PathVariable("no") long no, HttpServletRequest request){
        TestVO result =null;
        HttpStatus status = null;
        try{
            logger.info("Call getTestById"); 
            logger.info(request.getRemoteAddr());
            Optional<TestVO> test = testService.findByNo(no); 
            logger.info("result >> ", result);
            if(test == null){
                result = new TestVO();
            }
            else {
                result = test.get();
            }
            status = HttpStatus.OK;
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<TestVO>(result, status); 
    }

    @PostMapping
    public ResponseEntity<TestVO> saveTest(@RequestBody TestVO testVO, HttpServletRequest request, HttpServletResponse response) {
        TestVO result =null;
        HttpStatus status = null;

        if(!ipCheck(request.getRemoteAddr())){
            return new ResponseEntity<TestVO>(new TestVO(), HttpStatus.FORBIDDEN);
        }
        try{
            logger.info(request.getRemoteAddr());
            logger.info("Call save");
            result = testService.save(testVO);
            status = HttpStatus.OK;
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<TestVO>(result, status);
    }
    
    @PutMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TestVO> updateTest(@PathVariable long no, @RequestBody TestVO testVO, HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = null;
        if(!ipCheck(request.getRemoteAddr())){
            return new ResponseEntity<TestVO>(new TestVO(), HttpStatus.FORBIDDEN);
        }
        try{
            logger.info("Call save");
            testService.update(no, testVO);
            status = HttpStatus.OK;
            testVO.setNo(no);
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<TestVO>(testVO, status);
    } 

    @DeleteMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TestVO> deleteTest(@PathVariable long no, HttpServletRequest request, HttpServletResponse response){
        HttpStatus status = null;
        TestVO result =null;
        if(!ipCheck(request.getRemoteAddr())){
            return new ResponseEntity<TestVO>(new TestVO(), HttpStatus.FORBIDDEN);
        }
        try{
            Optional<TestVO> test  = testService.findByNo(no); 
            result = test.get();
            logger.info("Call delete");
            testService.deleteByNo(no);
            status = HttpStatus.OK;
            
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<TestVO>(result, status);
    }
}