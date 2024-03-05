package com.superb.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private Long id;
    private String name;
    private String pwd;
    // 头像url
    private String headImg;
    // 权限：1/0
    private Integer power;
    // 状态：启用/禁用
    private Integer status;
    // 是否被删
    private Integer del;
}
