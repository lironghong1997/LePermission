package com.permission.exception;
/**
* @version:1.0.0
* @author: lironghong
* @date: 2019/4/10 23:18
* @description: 自定义异常
*/
public class PermissionException extends RuntimeException{
    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
