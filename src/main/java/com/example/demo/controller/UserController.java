package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        return "User added successfully";
    }

//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        if (id == null || id <= 0) {
//            throw new DatabaseException("Invalid user ID");
//        }
//        return userService.getById(id);
//    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        if (id <= 0) {
            throw new CustomException(ErrorCode.INVALID_USER_ID);  // 抛出自定义异常
        }

        // 假设查找用户的业务逻辑
        if (id == 999) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);  // 抛出用户未找到的异常
        }

        // 如果用户找到，返回用户信息
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.list();
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        userService.updateById(user);
        return "User updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeById(id);
        return "User deleted successfully";
    }
}
