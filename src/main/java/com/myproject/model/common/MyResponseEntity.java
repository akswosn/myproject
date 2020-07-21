package com.myproject.model.common;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Builder(builderMethodName = "builder")
public class MyResponseEntity<T> {
    private int code = 200;
    private String message;
    private boolean check = true;
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