package com.myproject.model.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class MyResponseEntity<T> {
    private int code = 200;
    private String message;
    private boolean check = true;
    private T data;

    
}