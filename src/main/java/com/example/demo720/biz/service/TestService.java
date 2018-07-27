package com.example.demo720.biz.service;

import com.example.demo720.domain.entity.Test;

public interface TestService {
    public int insert(Test test)throws Exception;
    public Test selectOneByName(String name)throws Exception;
}
