package com.example.demo.exception;

import com.example.demo.Resp.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice  // 表示该类是全局异常处理器
public class GlobalExceptionHandler {

    // 处理数据库异常
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<Resp> handleDatabaseException(DatabaseException ex) {
        // 打印日志，记录错误信息
        System.err.println("Database error occurred: " + ex.getMessage());

        // 返回统一的错误响应
        Resp<String> response = new Resp<>(500, "Database error: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理其他运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Resp> handleRuntimeException(RuntimeException ex) {
        System.err.println("Runtime error occurred: " + ex.getMessage());
        Resp<String> response = new Resp<>(500, "An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理所有异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Resp> handleException(Exception ex) {
        System.err.println("Unknown error occurred: " + ex.getMessage());
        Resp<String> response = new Resp<>(500, "An unknown error occurred.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理自定义的资源未找到异常
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Resp> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Resp<String> response = new Resp<>(404, "Resource not found: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 可以根据需要继续扩展其他异常处理方法
}
