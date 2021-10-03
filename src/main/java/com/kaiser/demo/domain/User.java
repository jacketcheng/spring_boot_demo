package com.kaiser.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "用户表")
public class User {

    @ApiModelProperty(value = "用户id")
    private Long id;

//    @ApiModelProperty(value = "用户创建时间")
//    private Date createdTime;


    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
