package com.example.demo.exception;

public class CustomException extends RuntimeException {

    private final int code;  // 错误码

    // 构造函数
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    // 获取错误码
    public int getCode() {
        return code;
    }
}
