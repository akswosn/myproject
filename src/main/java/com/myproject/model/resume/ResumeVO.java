package com.myproject.model.resume;

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
@ApiModel(value = "Resume Entity", description = "이력서 엔티티")
public class ResumeVO {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "PK")
    private long no;

    @ApiModelProperty(value = "이력서 제목")
    private String title;

    @ApiModelProperty(value = "이름")
    private String name;

    @ApiModelProperty(value = "전화번호")
    private String phone;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "인삿말")
    private String summary;

    @ApiModelProperty(value = "보유스킬")
    private String skill;

    @Column(name = "repo_url")
    @ApiModelProperty(value = "개인 repository URL")
    private String repoUrl;

    @ApiModelProperty(value = "등록일")
    private LocalDateTime rdate;    
    
    @ApiModelProperty(value = "수정일")
    private LocalDateTime udate;
    
}