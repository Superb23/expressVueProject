package com.superb.controller;

import com.superb.common.Result;
import com.superb.pojo.dto.CourseDeleteDTO;
import com.superb.pojo.dto.CourseListDTO;
import com.superb.pojo.dto.CourseUpdateDTO;
import com.superb.pojo.vo.CourseListVo;
import com.superb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 分页查询课程信息
     * @param courseListDTO
     * @return
     */
    @GetMapping("/find")
    public Result<CourseListVo> getByCategoryWithPageQuery(CourseListDTO courseListDTO) {
        CourseListVo courseList = courseService.getCourseListByCategory(courseListDTO);
        return Result.success(courseList);
    }

    /**
     * 修改课程信息
     * @param courseUpdateDTO
     * @return
     */
    @PutMapping("/update")
    public Result updateCourseInfo(@RequestBody CourseUpdateDTO courseUpdateDTO) {
        courseService.updateCourseInfo(courseUpdateDTO);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteCourse(CourseDeleteDTO courseDeleteDTO) {
        courseService.deleteCourse(courseDeleteDTO);
        return Result.success();
    }
}
