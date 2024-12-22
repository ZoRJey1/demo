package com.example.demo.exception;

public enum ErrorCode {
    USER_NOT_FOUND(404, "User not found"),
    INVALID_USER_ID(400, "Invalid user ID"),
    DATABASE_ERROR(500, "Database error occurred"),
    UNAUTHORIZED_ACCESS(403, "Unauthorized access");

    private final int code;   // 错误码
    private final String message;  // 错误信息

    // 构造函数
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 获取错误码
    public int getCode() {
        return code;
    }

    // 获取错误信息
    public String getMessage() {
        return message;
    }
}
