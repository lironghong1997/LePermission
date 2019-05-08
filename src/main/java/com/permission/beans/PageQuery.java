package com.permission.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/5/8 15:24
* @description: 
*/
public class PageQuery {
    @Getter
    @Setter
    @Min(value = 1,message = "当前页码不合法")
    private int pageNo = 1;
    @Getter
    @Setter
    @Min(value = 1,message = "每页展示的数量不合法")
    private int pageSize = 10;
    //偏移量
    @Setter
    private int offset;

    public int getOffset() {
        return (pageNo-1) * pageSize;
    }
}
