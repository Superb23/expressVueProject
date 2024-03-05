package com.superb.service;

import com.superb.pojo.dto.ClientDeleteDTO;
import com.superb.pojo.dto.ClientListDTO;
import com.superb.pojo.dto.ClientUpdateInfoDTO;
import com.superb.pojo.dto.ClientUpdateStatusDTO;
import com.superb.pojo.vo.ClientListVo;

public interface ClientService {

    /**
     * 查询用户信息
     * @param clientListDTO
     * @return
     */
    ClientListVo getClientList(ClientListDTO clientListDTO);

    /**
     * 修改用户状态
     * @param clientUpdateStatusDTO
     */
    void updateClientStatus(ClientUpdateStatusDTO clientUpdateStatusDTO);

    /**
     * 删除用户
     * @param clientDeleteDTO
     */
    void deleteClient(ClientDeleteDTO clientDeleteDTO);

    /**
     * 修改用户信息
     * @param clientUpdateInfoDTO
     */
    void updateClientInfo(ClientUpdateInfoDTO clientUpdateInfoDTO);
}
