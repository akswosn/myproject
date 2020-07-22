package com.myproject.model.test;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Data
@Entity(name="tb_test")
@ApiModel(value = "Test Entity", description = "TEST 엔티티")
public class TestVO {
    @Id
    @Column(name = "NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "PK")
    private long no;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "내용")
    private String contents;

    @ApiModelProperty(value = "등록일")
    private LocalDateTime rdate;

    @ApiModelProperty(value = "수정일")
    private LocalDateTime udate;
}