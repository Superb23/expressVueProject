package com.superb.service.impl;

import com.superb.common.HeadImage;
import com.superb.mapper.AdminMapper;
import com.superb.pojo.dto.AdminDeleteDTO;
import com.superb.pojo.dto.AdminLoginDTO;
import com.superb.pojo.dto.AdminRegisterDTO;
import com.superb.pojo.dto.AdminStatusDTO;
import com.superb.pojo.entity.Admin;
import com.superb.pojo.entity.AdminInfo;
import com.superb.pojo.vo.AdminListVo;
import com.superb.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(AdminLoginDTO adminLoginDTO) {
        String userName = adminLoginDTO.getUserName();
        Admin admin = adminMapper.getByName(userName);

        return admin;
    }


    public void register(AdminRegisterDTO adminRegisterDTO) {
        String password = adminRegisterDTO.getPassword();
        Admin admin = new Admin();
        admin.setName(adminRegisterDTO.getUserName());
        // md5加密
        admin.setPwd(DigestUtils.md5DigestAsHex(password.getBytes()));
        admin.setHeadImg(HeadImage.getRandomImage());
        admin.setPower(0);
        admin.setStatus(1);
        admin.setDel(0);
        adminMapper.insert(admin);
    }


    public AdminListVo getAdminList() {
        Admin admin = new Admin();
        admin.setPower(0);
        admin.setDel(0);
        List<Admin> adminList = adminMapper.queryCondition(admin);
        List<AdminInfo> adminInfos = new ArrayList<>();
        adminList.forEach(item -> {
            AdminInfo adminInfo = new AdminInfo();
            BeanUtils.copyProperties(item, adminInfo);
            adminInfos.add(adminInfo);
        });
        AdminListVo adminListVo = new AdminListVo();
        adminListVo.setAdminList(adminInfos);
        return adminListVo;
    }


    public void updateAdminStatus(AdminStatusDTO adminStatusDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminStatusDTO, admin);
        adminMapper.update(admin);
    }


    public void deleteAdmin(AdminDeleteDTO adminDeleteDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDeleteDTO, admin);
        admin.setDel(1);
        adminMapper.update(admin);
    }
}
