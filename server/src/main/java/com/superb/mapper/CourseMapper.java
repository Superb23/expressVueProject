package com.superb.mapper;

import com.github.pagehelper.Page;
import com.superb.pojo.dto.CourseListDTO;
import com.superb.pojo.dto.CourseUpdateDTO;
import com.superb.pojo.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CourseMapper {

    /**
     * 分页查询
     * @param courseListDTO
     * @return
     */
    Page<Course> pageQuery(CourseListDTO courseListDTO);

    /**
     * 根据id动态修改
     * @param course
     */
    void update(Course course);

    /**
     * 根据id删除数据
     * @param id
     */
    @Update("update video set del = 1 where id = #{id}")
    void deleteById(Long id);
}
