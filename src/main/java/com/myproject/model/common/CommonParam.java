package com.myproject.model.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class CommonParam {

    private long no;
    private int page;
    private int listCount;
    private String sort;
    
}