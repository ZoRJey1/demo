package com.example.demo.controller;

import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.save(user);
        return "User added successfully";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        if (id == null || id <= 0) {
            throw new DatabaseException("Invalid user ID");
        }
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
