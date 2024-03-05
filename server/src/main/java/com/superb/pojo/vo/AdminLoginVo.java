package com.superb.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginVo implements Serializable {

    private String name;
    private String headImg;
    // token认证
    private String token;

    // 管理员权限 1 / 0
    private int power;

}
