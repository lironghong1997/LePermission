package com.permission.model;

import lombok.Data;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 
*/
@Data
public class SysLogWithBLOBs extends SysLog {
    private String oldValue;

    private String newValue;


}