package com.permission.common;

import com.permission.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/25 20:29
* @description: Http请求监听
*/
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    //请求处理之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start url:{},paramterMap:{}",url, JsonUtils.objtoString(parameterMap));
        return true;
    }
    //请求正常结束时候
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request finished url:{},paramterMap:{}",url, JsonUtils.objtoString(parameterMap));
    }
    //在任何请求结束的时候包括异常的时候也触发执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request exception url:{},paramterMap:{}",url, JsonUtils.objtoString(parameterMap));
    }

}
