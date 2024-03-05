package com.superb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.superb.mapper.ClientMapper;
import com.superb.pojo.dto.ClientDeleteDTO;
import com.superb.pojo.dto.ClientListDTO;
import com.superb.pojo.dto.ClientUpdateInfoDTO;
import com.superb.pojo.dto.ClientUpdateStatusDTO;
import com.superb.pojo.entity.Client;
import com.superb.pojo.vo.ClientListVo;
import com.superb.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    public ClientListVo getClientList(ClientListDTO clientListDTO) {
        PageHelper.startPage(clientListDTO.getPage(), clientListDTO.getSize());

        Page<Client> page = clientMapper.pageQuery(clientListDTO);
        long total = page.getTotal();
        List<Client> clientList = page.getResult();

        ClientListVo clientListVo = new ClientListVo();
        clientListVo.setClientList(clientList);
        clientListVo.setTotal(total);

        return clientListVo;
    }

    public void updateClientStatus(ClientUpdateStatusDTO clientUpdateStatusDTO) {
        Long id = clientUpdateStatusDTO.getId();
        Integer status = clientUpdateStatusDTO.getStatus();
        clientMapper.updateStatusById(id, status);
    }

    public void deleteClient(ClientDeleteDTO clientDeleteDTO) {
        Long id = clientDeleteDTO.getId();
        clientMapper.deleteById(id);
    }

    public void updateClientInfo(ClientUpdateInfoDTO clientUpdateInfoDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientUpdateInfoDTO, client);
        clientMapper.update(client);
    }

}
