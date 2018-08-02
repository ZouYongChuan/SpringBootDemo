package com.example.demo720.biz.serviceimpl;

import com.example.demo720.biz.service.UserService;
import com.example.demo720.config.DS;
import com.example.demo720.domain.dao.UserMapper;
import com.example.demo720.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zou
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @DS("datasource1")
    @Cacheable(value = "userbyphone",key = "#phone")
    @Transactional(rollbackFor = Exception.class)
    public User getUserByPhone(String phone)throws Exception {
        return  userMapper.findUserByPhone(phone);
    }

    @Override
    @DS("datasource1")
    @Transactional(rollbackFor = Exception.class)
    public int insert(String name, String password, String phone) throws Exception {
        return userMapper.insert(name,password,phone);
    }

    @Override
    @DS("datasource1")
    @Cacheable(value = "usernamebyphone",key = "#phone")
    @Transactional(rollbackFor = Exception.class)
    public String getUsernameByPhone(String phone)throws Exception {
        return userMapper.getUsernameByPhone(phone);
    }
}
