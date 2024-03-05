package com.superb.controller;

import com.superb.common.JwtConstant;
import com.superb.common.JwtProperties;
import com.superb.common.JwtUtil;
import com.superb.common.Result;
import com.superb.pojo.dto.AdminDeleteDTO;
import com.superb.pojo.dto.AdminLoginDTO;
import com.superb.pojo.dto.AdminRegisterDTO;
import com.superb.pojo.dto.AdminStatusDTO;
import com.superb.pojo.entity.Admin;
import com.superb.pojo.vo.AdminListVo;
import com.superb.pojo.vo.AdminLoginVo;
import com.superb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<AdminLoginVo> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        Admin admin = adminService.login(adminLoginDTO);
        if (admin == null) {
            return Result.error(2,"账号不存在，请先注册");
        }
        if (admin.getStatus() == 0 || admin.getDel() == 1) {
            return Result.error(3,"账号异常，请联系管理员解决");
        }
        String password = adminLoginDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPwd())) {
            return Result.error(4,"账号或密码错误");
        }

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstant.EMP_ID, admin.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        AdminLoginVo adminLoginVo = new AdminLoginVo();
        adminLoginVo.setName(admin.getName());
        adminLoginVo.setHeadImg(admin.getHeadImg());
        adminLoginVo.setToken(token);
        adminLoginVo.setPower(admin.getPower());
        return Result.success(adminLoginVo);
    }

    /**
     * 管理员账号注册
     * @param adminRegisterDTO
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        adminService.register(adminRegisterDTO);
        return Result.success();
    }

    /**
     * 管理员账号列表
     * @return
     */
    @GetMapping("/userList")
    public Result<AdminListVo> getAdminList() {
        AdminListVo adminListVo = adminService.getAdminList();
        return Result.success(adminListVo);
    }

    /**
     * 更改账号状态（启用/停用）
     * @param adminStatusDTO
     * @return
     */
    @GetMapping("/update/status")
    public Result updateAdminStatus(AdminStatusDTO adminStatusDTO) {
        adminService.updateAdminStatus(adminStatusDTO);
        return Result.success();
    }

    /**
     * 删除账号
     * @param adminDeleteDTO
     * @return
     */
    @GetMapping("/delete")
    public Result deleteAdmin(AdminDeleteDTO adminDeleteDTO) {
        adminService.deleteAdmin(adminDeleteDTO);
        return Result.success();
    }
}
