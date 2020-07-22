package com.myproject.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
/**
* <pre>
* 간략 : common param Entity
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
@ApiModel(value = "Common Param Entity", description = "공통 파라미터 정의")
public class CommonParam {
    @ApiModelProperty(value = "PK")
    private long no;
    @ApiModelProperty(value = "페이지 번호")
    private int page;
    @ApiModelProperty(value = "리스트 갯수")
    private int listCount;
    @ApiModelProperty(value = "정렬기준")
    private String sort;
    @ApiModelProperty(value = "검색조건")
    private String searchType;
    @ApiModelProperty(value = "검색값")
    private String searchValue;
    
}