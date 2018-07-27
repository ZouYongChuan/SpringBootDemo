package com.example.demo720.controller;

import com.example.demo720.biz.service.UserService;
import com.example.demo720.biz.serviceimpl.UserServiceImpl;
import com.example.demo720.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zou
 */
@RestController
public class UserController {

    private  UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user/user/{phone}")
    public User getUserByPhone(@PathVariable("phone") String phone)throws Exception {
        return userServiceImpl.getUserByPhone(phone);
    }

    @GetMapping("/user/phone/{phone}")
    public String getUserNameByPhone(@PathVariable("phone") String phone)throws Exception {
        return userServiceImpl.getUsernameByPhone(phone);
    }

    @GetMapping("/hello")
    public Object sayHello(@RequestParam("name") String name)throws Exception  {
        System.out.println("name: " + name);
        return "hello " + name;
    }
}
