package com.superb.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientUpdateInfoDTO implements Serializable {
    private Long id;
    private String name;
    private String sex;
    private String cardNumber;
    private Integer type;
    private String books;
}
