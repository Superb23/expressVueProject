package com.superb.pojo.vo;

import com.superb.pojo.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseListVo implements Serializable {
    private List<Course> courseList;
    private Long total;
}
