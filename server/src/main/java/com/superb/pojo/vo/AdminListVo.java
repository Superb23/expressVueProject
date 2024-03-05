package com.superb.pojo.vo;

import com.superb.pojo.entity.AdminInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminListVo implements Serializable {
    private List<AdminInfo> adminList;
}
