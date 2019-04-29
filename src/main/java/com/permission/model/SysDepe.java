package com.permission.model;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 
*/
@Builder
@Data
public class SysDepe {
    private Integer id;

    private String name;

    private Integer parentId;

    private String levle;

    private Integer seq;

    private String remark;

    private String operator;

    private Date operateTime;

    private String operateIp;


}