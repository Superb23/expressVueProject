package com.superb.service;

import com.superb.pojo.dto.AdminDeleteDTO;
import com.superb.pojo.dto.AdminLoginDTO;
import com.superb.pojo.dto.AdminRegisterDTO;
import com.superb.pojo.dto.AdminStatusDTO;
import com.superb.pojo.entity.Admin;
import com.superb.pojo.vo.AdminListVo;

import javax.security.auth.login.AccountNotFoundException;

public interface AdminService {

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     * @throws AccountNotFoundException
     */
    Admin login(AdminLoginDTO adminLoginDTO);


    /**
     * 管理员账号注册
     * @param adminRegisterDTO
     */
    void register(AdminRegisterDTO adminRegisterDTO);

    /**
     * 管理员列表
     * @return
     */
    AdminListVo getAdminList();

    /**
     * 更改管理员账号状态
     * @param adminStatusDTO
     */
    void updateAdminStatus(AdminStatusDTO adminStatusDTO);

    /**
     * 删除管理员账号
     * @param adminDeleteDTO
     */
    void deleteAdmin(AdminDeleteDTO adminDeleteDTO);
}
