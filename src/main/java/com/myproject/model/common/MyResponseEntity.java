package com.myproject.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
* <pre>
* 간략 : Response Entity
* 상세 : 
* </pre>
* @Author  : Keun-su(akswosn@gmail)
* @Date    : 2020. 6. 18.
* @Version : 1.0 (v1)
* -----------------------------------
* 1.0 : 신규작성
*/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Builder(builderMethodName = "builder")
@ApiModel(value = "Response Container", description = "모든 응답의 기본 구조")
public class MyResponseEntity<T> {
    
    @Builder.Default
    @ApiModelProperty(value = "HTTP 상태 코드")
    private int code = 200;

    @ApiModelProperty(value = "결과 메시지")
    private String message;

    
    @Builder.Default
    @ApiModelProperty(value = "성공여부 (200=true or others=false)")
    private boolean check = true;

    @ApiModelProperty(value = "결과 데이터")
    private T data;

    
    public static <T> MyResponseEntity<T> success(){
        return MyResponseEntity.<T>builder()
            .code(200).check(true)
            .build();
    }

    public static <T> MyResponseEntity<T> success(T data){
        return MyResponseEntity.<T>builder()
            .code(200).check(true).data(data)
            .build();
    }

    public static <T> MyResponseEntity<T> success(String message, T data){
        return MyResponseEntity.<T>builder()
            .code(200).check(true).data(data).message(message)
            .build();
    }

    public static <T> MyResponseEntity<T> error(int code, String message){
        return MyResponseEntity.<T>builder()
            .code(code).check(false).message(message)
            .build();
    }

    public static <T> MyResponseEntity<T> error(int code, String message, T data){
        return MyResponseEntity.<T>builder()
            .code(code).check(false).message(message).data(data)
            .build();
    }
}