package com.superb.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientUpdateStatusDTO implements Serializable {
    private Long id;
    private Integer status;
}
