package com.myproject.model;

import java.time.LocalDateTime;
import java.util.Random;

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
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_no;
    private LocalDateTime login_time;
    private String session_key;


    public String randomSessionKey(int length){
        StringBuffer temp = new StringBuffer();
        Random rnd = new Random();
        int count = 0;

        while(length > count){
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                    count++;
                    break;
                case 1:
                    // A-Z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                    count++;
                    break;
                case 2:
                    // 0-9
                    temp.append((rnd.nextInt(10)));
                    count++;
                    break;
                default :

            }
        }
        
        
        return temp.toString();
    }

    public static void main(String[] args){
        WebSessionVO vo = new WebSessionVO();
        System.out.println(vo.randomSessionKey(20).length());
    }
}