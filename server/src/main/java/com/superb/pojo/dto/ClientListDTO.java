package com.superb.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientListDTO implements Serializable {
    private String type;
    private Integer size;
    private Integer page;
}
