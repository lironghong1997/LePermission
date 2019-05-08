package com.permission.common;

import com.permission.model.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/5/8 16:40
* @description:  ThreadLocal
*/
public class RequestHolder {

    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(SysUser sysUser){
        userHolder.set(sysUser);
    }
    public static void add(HttpServletRequest request){
        requestHolder.set(request);
    }

    public static SysUser getCurrentUser(){
        return userHolder.get();
    }
    public static HttpServletRequest getCurrentRequest(){
        return requestHolder.get();
    }
    public static void remove () {
        userHolder.remove();
        requestHolder.remove();
    }
}
