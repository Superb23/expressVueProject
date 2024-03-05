package com.superb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.superb.mapper.CourseMapper;
import com.superb.pojo.dto.CourseDeleteDTO;
import com.superb.pojo.dto.CourseListDTO;
import com.superb.pojo.dto.CourseUpdateDTO;
import com.superb.pojo.entity.Course;
import com.superb.pojo.vo.CourseListVo;
import com.superb.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public CourseListVo getCourseListByCategory(CourseListDTO courseListDTO) {
        PageHelper.startPage(courseListDTO.getPage(), courseListDTO.getSize());
        Page<Course> page = courseMapper.pageQuery(courseListDTO);
        long total = page.getTotal();
        List<Course> courseList = page.getResult();

        CourseListVo courseListVo = new CourseListVo();
        courseListVo.setCourseList(courseList);
        courseListVo.setTotal(total);
        return courseListVo;
    }

    public void updateCourseInfo(CourseUpdateDTO courseUpdateDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseUpdateDTO, course);
        courseMapper.update(course);
    }

    public void deleteCourse(CourseDeleteDTO courseDeleteDTO) {
        Long id = courseDeleteDTO.getId();
        courseMapper.deleteById(id);
    }
}
