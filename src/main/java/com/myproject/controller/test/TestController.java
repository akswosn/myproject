package com.myproject.controller.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.model.common.MyResponseEntity;
import com.myproject.model.test.TestVO;
import com.myproject.service.test.TestService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
* <pre>
* 간략 : Web test API
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 18.
* @Version : 1.0 (v1)
* -----------------------------------
* 1.0 : 신규작성
*/
@RestController
@RequestMapping("v1/api/test")
@Api(value="TEST API", description="rest API TEST")
public class TestController {
    private final Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    private String[] IP_LIST = {"127.0.0.1", "211.62.247.33"};

    private boolean ipCheck(String ip){
        boolean result = Arrays.stream(IP_LIST).anyMatch(ip::equals);
        return result;
    }

    @ApiOperation(value = "Select All",response = MyResponseEntity.class)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public MyResponseEntity<List<TestVO>> getAllTest() { 
        List<TestVO> result =null;
        MyResponseEntity<List<TestVO>> resp = null;
        try{
            logger.info("Call getAllTest");
            result = testService.findAll(); 
            resp = MyResponseEntity.success(result);
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500,e.getLocalizedMessage());
        }
        return resp; 
    }

    @ApiOperation(value = "Select One",response = MyResponseEntity.class)
    @GetMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public MyResponseEntity<TestVO> getTestById(@PathVariable("no") long no, HttpServletRequest request){
        TestVO result =null;
        MyResponseEntity<TestVO> resp = null;
        try{
            logger.info("Call getTestById"); 
            Optional<TestVO> test = testService.findByNo(no); 
            logger.info("result >> ", result);
            if(test == null){
                result = new TestVO();
            }
            else {
                result = test.get();
            }
            resp = MyResponseEntity.success(result);
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }
        return resp; 
    }

    @ApiOperation(value = "Save",response = MyResponseEntity.class)
    @PostMapping
    public MyResponseEntity<TestVO> saveTest(@RequestBody TestVO testVO, HttpServletRequest request, HttpServletResponse response) {
        TestVO result =null;
        MyResponseEntity<TestVO> resp = null;

        if(!ipCheck(request.getRemoteAddr())){
            return MyResponseEntity.error(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        }
        try{
            logger.info(request.getRemoteAddr());
            logger.info("Call save");
            result = testService.save(testVO);
            resp = MyResponseEntity.success(result);
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }
        return resp;
    }
    
    @ApiOperation(value = "update",response = MyResponseEntity.class)
    @PutMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public MyResponseEntity<TestVO> updateTest(@PathVariable long no, @RequestBody TestVO testVO, HttpServletRequest request, HttpServletResponse response) {
        MyResponseEntity<TestVO> resp = null;
        if(!ipCheck(request.getRemoteAddr())){
            return MyResponseEntity.error(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        }
        try{
            logger.info("Call save");
            testService.update(no, testVO);
            testVO.setNo(no);
            resp = MyResponseEntity.success();
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }
        return resp;
    } 

    @ApiOperation(value = "Delete",response = MyResponseEntity.class)
    @DeleteMapping(value="/{no}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public MyResponseEntity<TestVO> deleteTest(@PathVariable long no, HttpServletRequest request, HttpServletResponse response){
        MyResponseEntity<TestVO> resp = null;
        TestVO result =null;
        if(!ipCheck(request.getRemoteAddr())){
            return MyResponseEntity.error(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        }
        try{
            Optional<TestVO> test  = testService.findByNo(no); 
            result = test.get();
            logger.info("Call delete");
            testService.deleteByNo(no);
            resp = MyResponseEntity.success(result);
            
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            resp = MyResponseEntity.error(500, e.getLocalizedMessage());
        }
        return resp;
    }
}