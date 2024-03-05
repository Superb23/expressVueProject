package com.superb.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo implements Serializable {
    private Long id;
    private String name;
    private Integer status;
}
