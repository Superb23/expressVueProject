package com.superb.controller;

import com.superb.common.Result;
import com.superb.pojo.dto.ClientDeleteDTO;
import com.superb.pojo.dto.ClientListDTO;
import com.superb.pojo.dto.ClientUpdateInfoDTO;
import com.superb.pojo.dto.ClientUpdateStatusDTO;
import com.superb.pojo.vo.ClientListVo;
import com.superb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public Result<ClientListVo> getClientList(ClientListDTO clientListDTO) {
        ClientListVo clientListVo = clientService.getClientList(clientListDTO);

        return Result.success(clientListVo);
    }

    @PutMapping("/update/status")
    public Result updateClientStatus(@RequestBody ClientUpdateStatusDTO clientUpdateStatusDTO) {
        clientService.updateClientStatus(clientUpdateStatusDTO);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteClient(@RequestBody ClientDeleteDTO clientDeleteDTO) {
        clientService.deleteClient(clientDeleteDTO);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateClientInfo(@RequestBody ClientUpdateInfoDTO clientUpdateInfoDTO) {
        clientService.updateClientInfo(clientUpdateInfoDTO);
        return Result.success();
    }
}
