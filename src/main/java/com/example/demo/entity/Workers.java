package com.example.demo.entity;

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
public class Workers implements Serializable {
    private int page;
    private int limit;

    /**
     * ID
     */
    private String id;
    /**
     * 部门名
     */
    private String empName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 部门
     */
    private String deptName;
    /**
     * 学位
     */
    private String empDegreeName;

}
