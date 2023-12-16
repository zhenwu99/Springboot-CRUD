package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@ApiModel("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    @ApiModelProperty("avatar")
    private String avatar;

//    @ApiModelProperty("name")
    private String name;

//    @ApiModelProperty("introduction")
    private String introduction;

//    @ApiModelProperty("roles")
    private List<String> roles;
}
