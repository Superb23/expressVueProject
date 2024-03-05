package com.superb.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private Long id;
    private String title;
    private String courseImg;
    private String price;
    private Double point;
    private String category;
    private Integer del;
}
