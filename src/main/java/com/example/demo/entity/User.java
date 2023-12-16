package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("介绍")
    private String introduction;

    @ApiModelProperty("权限")
    private List<String> roles;
}
