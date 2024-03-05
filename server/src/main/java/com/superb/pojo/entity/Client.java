package com.superb.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    private Long id;
    private String name;
    private String sex;
    private String cardNumber;
    private Integer type;
    private Integer status;
    private String books;
    private Integer del;
}
