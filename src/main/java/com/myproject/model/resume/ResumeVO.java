package com.myproject.model.resume;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
* <pre>
* 간략 : 이력서 엔티티
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 7. 01.
* @Version : 1.0
* -----------------------------------
* 1.0 : 신규작성
*/

@Data
@Entity(name="tb_resume")
public class ResumeVO {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String title;
    private String name;
    private String phone;
    private String email;
    private String summary;
    private String skill;
    @Column(name = "repo_url")
    private String repoUrl;
    private LocalDateTime rdate;                                                                                                                           
    private LocalDateTime udate;
    
}