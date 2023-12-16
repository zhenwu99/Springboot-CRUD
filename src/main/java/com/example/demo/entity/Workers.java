package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 员工表
 * @TableName workers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("workers")
public class Workers extends Page implements Serializable{

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    /**
     * 部门名
     */
    @ApiModelProperty("部门名")
    private String empName;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private String age;
    /**
     * 部门
     */
    @ApiModelProperty("部门")
    private String deptName;
    /**
     * 学位
     */
    @ApiModelProperty("学历")
    private String empDegreeName;

}
