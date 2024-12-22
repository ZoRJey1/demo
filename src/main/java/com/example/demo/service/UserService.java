package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    // 你可以在这里添加自定义的业务逻辑

    @Autowired
    private UserMapper userMapper;

    // 你可以在这里编写具体的业务逻辑方法
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    public boolean addUser(User user) {
        return save(user);  // MyBatis-Plus 提供的保存方法
    }

    public boolean updateUser(User user) {
        return updateById(user);  // MyBatis-Plus 提供的更新方法
    }

    public boolean deleteUser(Long id) {
        return removeById(id);  // MyBatis-Plus 提供的删除方法
    }
}
