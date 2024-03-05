package com.superb.mapper;

import com.superb.pojo.dto.AdminRegisterDTO;
import com.superb.pojo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Select("select * from user where name = #{name}")
    Admin getByName(String name);

    /**
     * 新增用户数据
     * @param admin
     */
    void insert(Admin admin);

    /**
     * 条件查询
     * @param admin
     * @return
     */
    List<Admin> queryCondition(Admin admin);

    /**
     * 根据id动态更新
     * @param admin
     */
    void update(Admin admin);

}
