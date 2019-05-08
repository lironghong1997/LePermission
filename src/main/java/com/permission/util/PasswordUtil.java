package com.permission.util;

import org.junit.Test;

import java.util.Random;

/**
 * @version:1.0.0
 * @author: lironghong
 * @date: 2019/5/7 18:01
 * @description:
 */
public class PasswordUtil {
    //定义可以使用的字符
    private final static String[] world = {
            "a","b","c","d","e","f","g",
            "h","j","k","m","n","p","q",
            "r","s","t","u","v","w","x",
            "y","z","A","B","C","D","E",
            "F","G","H","J","K","M","N",
            "P","Q","R","S","T","U","V",
            "W","X","Y","Z"
    };
    private final static String[] num = {
             "2","3","4","5","6","7", "8","9"
    };
    public static String randomPassword() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random(System.currentTimeMillis());
        boolean flag = false;
        //相当于密码在8到10位
       int length = random.nextInt(3) + 8;
       for (int i = 0; i < length; i++) {
           if (flag) {
               stringBuffer.append(num[random.nextInt(num.length)]);
           }else {
               stringBuffer.append(world[random.nextInt(world.length)]);
           }
           flag = !flag;
       }
       return stringBuffer.toString();
    }
}
