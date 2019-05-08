package com.permission.beans;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/5/8 15:25
* @description: 
*/
@Data
@ToString
@Builder
public class PageResult <T>{
    private List<T> date = Lists.newArrayList();

    private int total = 0;

}
