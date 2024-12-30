package com.liqingitt.exam_system.exceptions;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private  Integer code;
    private final String message;
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException( String message) {
        super(message);
        this.code = 400;
        this.message = message;
    }

    public BusinessException() {
        super("请求出错");
        this.code = 400;
        this.message = "请求出错";
    }

}