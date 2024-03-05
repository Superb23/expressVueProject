package com.superb.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseListDTO implements Serializable {
    private String category;
    private Integer size;
    private Integer page;
}
