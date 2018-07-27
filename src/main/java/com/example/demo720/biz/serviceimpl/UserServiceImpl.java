package com.example.demo720.biz.serviceimpl;

import com.example.demo720.biz.service.UserService;
import com.example.demo720.config.DS;
import com.example.demo720.domain.entity.User;
import com.example.demo720.domain.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

/**
 * @author zou
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @DS("datasource1")
    @Transactional(rollbackFor = Exception.class)
    public User getUserByPhone(String phone)throws Exception {
        return  userMapper.findUserByPhone(phone);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(String name, String password, String phone) throws Exception {
        return userMapper.insert(name,password,phone);
    }

    @Override
    @DS("datasource1")
    public String getUsernameByPhone(String phone)throws Exception {
        return userMapper.getUsernameByPhone(phone);
    }
}
