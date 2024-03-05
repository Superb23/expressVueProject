package com.superb.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDTO implements Serializable {
    // 用户名
    private String userName;

    // 密码
    private String password;
}
