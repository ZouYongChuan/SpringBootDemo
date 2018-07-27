package com.example.demo720.controller;

import com.example.demo720.biz.serviceimpl.TestServiceImpl;
import com.example.demo720.domain.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    private TestServiceImpl testService;
    @Autowired
    public TestController(TestServiceImpl testService){
        this.testService=testService;
    }
    @PostMapping("/test")
    public int testInsert(@RequestBody Test test)throws Exception{
        return testService.insert(test);
    }
    @GetMapping("/test/{name}")
    public Test testSelectOneByName(@PathVariable("name") String name)throws Exception{
        return testService.selectOneByName(name);
    }
}
