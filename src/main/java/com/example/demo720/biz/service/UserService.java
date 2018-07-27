package com.example.demo720.biz.service;

import com.example.demo720.domain.entity.User;

/***
 * @author zou
 */
public interface UserService {

    public User getUserByPhone(String phone) throws Exception;

    public int insert(String name, String password, String phone) throws Exception;

    public String getUsernameByPhone(String phone) throws Exception;
}
