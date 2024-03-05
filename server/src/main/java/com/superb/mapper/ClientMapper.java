package com.superb.mapper;

import com.github.pagehelper.Page;
import com.superb.pojo.dto.ClientListDTO;
import com.superb.pojo.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface ClientMapper {

    /**
     * 分页查询用户信息
     * @param clientListDTO
     * @return
     */
    Page<Client> pageQuery(ClientListDTO clientListDTO);

    /**
     * 根据id修改status
     * @param id
     * @param status
     */
    @Update("update client set status = #{status} where id = #{id}")
    void updateStatusById(Long id, Integer status);

    /**
     * 根据id删除用户
     * @param id
     */
    @Update("update client set del = 1 where id = #{id}")
    void deleteById(Long id);

    /**
     * 动态修改
     * @param client
     */
    void update(Client client);
}
