package com.permission.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/2 17:56
* @description: 统一json返回组件
*/
@Data
public class JsonData {
    private boolean ret;
    private String msg;
    private Object data;

    public JsonData (boolean ret){
        this.ret=ret;
    }

    public static JsonData success(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data=object;
        jsonData.msg=msg;
        return jsonData;
    }

    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data=object;
        return jsonData;
    }
    public static JsonData success(){
      return new JsonData(true);
    }

    public static JsonData failed(String msg){
        JsonData jsonData=new JsonData(false);
        jsonData.msg=msg;
        return jsonData;
    }
    //补充方法
    public Map<String,Object> tomap(){
        HashMap<String,Object> result=new HashMap<String,Object>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }

}
