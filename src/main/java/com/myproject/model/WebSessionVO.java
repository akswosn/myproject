package com.myproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class WebSessionVO {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column(name = "user_no")
    private long userNo;
    @Column(name = "login_time")
    private LocalDateTime loginTime;
    @Column(name = "session_key")
    private String sessionKey;

}