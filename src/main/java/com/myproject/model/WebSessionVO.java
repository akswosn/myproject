package com.myproject.model;

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
* 간략 : 
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 23.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/
@Data
@Entity(name="tb_web_session")
@ApiModel(value = "WebSession Entity", description = "웹세션 엔티티")
public class WebSessionVO {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "PK")
    private long no;
    
    @Column(name = "user_no")
    @ApiModelProperty(value = "사용자 고유번호")
    private long userNo;

    @Column(name = "login_time")
    @ApiModelProperty(value = "로그인시간")
    private LocalDateTime loginTime;

    @Column(name = "session_key")
    @ApiModelProperty(value = "세션 토큰")
    private String sessionKey;

}