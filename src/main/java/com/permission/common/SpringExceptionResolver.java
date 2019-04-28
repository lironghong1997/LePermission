package com.permission.common;

import com.permission.exception.ParamException;
import com.permission.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/4/16 23:18
 * @description: 统一捕获异常处理
 * 当我们的定义的resolver实现HandlerExceptionResolver后这个类被spring管理的话我们的全局异常在http进行返回的时候就会被这个类所捕捉住
 * 我们只需要在resolveException这个方法中实现我们异常处理逻辑就可以了
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        String url = httpServletRequest.getRequestURI().toString();
        /*
         * 该对象中包含了一个model属性和一个view属性
         * model：其实是一个ModelMap类型。其实ModelMap是一个LinkedHashMap的子类
         * view：包含了一些视图信息
         * 当视图解释器解析ModelAndVIew是，其中model本生就是一个Map的实现类的子类。视图解析器将model中的每个元素都通过request.setAttribute(name, value);添加request请求域中。这样就可以在JSP页面中通过EL表达式来获取对应的值*/
        ModelAndView mv = null;
        String defaultMsg = "System error";
        //数据请求使用 .json 页面请求使用 .page
        if (url.endsWith(".json")) {
            /*java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。*/
            if (e instanceof PermissionException || e instanceof ParamException) {
                JsonData jsonData = JsonData.failed(e.getMessage());
                //jsonView对应spring-servlet.xml中的jsonView配合（意思是返回值是用json返回的）
                mv = new ModelAndView("jsonView", jsonData.tomap());
            } else {
                log.error("{},{}","unknow json exception url:"+url,e);
                JsonData jsonData = JsonData.failed(defaultMsg);
                mv = new ModelAndView("jsonView", jsonData.tomap());
            }
        } else if (url.endsWith(".page")) {
            log.error("{},{}","unknow page exception url:"+url,e);
            JsonData jsondata = JsonData.failed(defaultMsg);
            //页面请求异常会找exception.jsp页面
            mv = new ModelAndView("exception", jsondata.tomap());
        } else {
            log.error("{},{}","unknow exception url:"+url,e);
            JsonData jsonData = JsonData.failed(defaultMsg);
            mv = new ModelAndView("jsonView", jsonData.tomap());
        }
        return mv;
    }
}



