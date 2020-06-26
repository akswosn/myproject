package com.myproject.model;



import java.io.Serializable;

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
@Entity(name="tb_user")
public class UserVO implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4765802872481803333L;
    
    @Id
    @Column(name = "NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String user_id;
    private String user_pwd;
    private String name;
    private int roll; 

}