package com.superb.pojo.vo;

import com.superb.pojo.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientListVo implements Serializable {
    private List<Client> clientList;
    private Long total;
}
