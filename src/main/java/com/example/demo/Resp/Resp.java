package com.example.demo.Resp;

public class Resp<T> {
    private Integer code;   // 错误码
    private String message;  // 错误信息
    private T data;          // 响应数据

    // 构造函数
    public Resp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Resp(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getter and Setter
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
