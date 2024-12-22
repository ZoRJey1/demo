package com.example.demo.exception;

public class InvalidDtoException extends RuntimeException {

    private final int code;  // 错误码

    public InvalidDtoException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
