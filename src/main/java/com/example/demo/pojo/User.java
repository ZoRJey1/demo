package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@TableName("user")  // 这里的 "user" 是数据库中的表名
public class User {

    @TableId  // 主键标注
    @NotNull(message = "User ID cannot be null")
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Age cannot be null")
    private Integer age;

    @NotNull(message = "Email cannot be null")
    private String email;

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
