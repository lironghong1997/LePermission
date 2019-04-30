package com.permission.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lironghong
 * @version 1.0.0
 * @date 2019/4/29 16:36
 * @description
 */
public class LevelUtil {
    //定义层级之间的分隔符
    public final static String SEPARATOR = ".";
    //定义root的id从0开始
    public  final static String ROOT = "0";
    //定义部门level的计算规则
    /*
    * 0
    * 0.1
    * 0.1.1
    * 0.1.2
    * 0.4*/
    public static String levelroolcalc(String parentlevel,int parentid){
        if (StringUtils.isBlank(parentlevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentlevel,SEPARATOR,parentid);
        }
    }

}
