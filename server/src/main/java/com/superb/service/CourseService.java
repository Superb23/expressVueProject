package com.superb.service;

import com.superb.pojo.dto.CourseDeleteDTO;
import com.superb.pojo.dto.CourseListDTO;
import com.superb.pojo.dto.CourseUpdateDTO;
import com.superb.pojo.vo.CourseListVo;

public interface CourseService {
    /**
     * 根据课程类型分页查询
     * @param courseListDTO
     * @return
     */
    CourseListVo getCourseListByCategory(CourseListDTO courseListDTO);

    /**
     * 修改课程信息
     * @param courseUpdateDTO
     */
    void updateCourseInfo(CourseUpdateDTO courseUpdateDTO);

    /**
     * 删除携程信息
     * @param courseDeleteDTO
     */
    void deleteCourse(CourseDeleteDTO courseDeleteDTO);
}
