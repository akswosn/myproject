package com.myproject.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
/**
 * <pre>
* 간략 : 로그인 param
* 상세 :
 * </pre>
 * 
 * @Author : Keun-su(akswosn@gmail)
 * @Date : 2020. 7. 22.
 * @Version : 1.0 ----------------------------------- 1.0 : 신규작성
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Login entity", description = "로그인 엔티티")
public class LoginParam {

    @ApiModelProperty(value = "계정명")
    private String userId;

    @ApiModelProperty(value = "비밀번호")
    private String userPwd;
}