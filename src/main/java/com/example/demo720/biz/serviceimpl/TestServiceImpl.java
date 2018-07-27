package com.example.demo720.biz.serviceimpl;

import com.example.demo720.biz.service.TestService;
import com.example.demo720.config.DS;
import com.example.demo720.domain.dao.TestMapper;
import com.example.demo720.domain.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    @DS("datasource2")
    public int insert(Test test)throws Exception {
        return testMapper.insert(test);
    }

    @Override
    @DS("datasource2")
    public Test selectOneByName(String name)throws Exception {
        return testMapper.selectOneByName(name);
    }
}
