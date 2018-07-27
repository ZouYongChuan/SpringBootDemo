package com.example.demo720.domain.dao;

import com.example.demo720.domain.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Insert("insert into test (name,sex,age) values(#{name},#{sex},#{age})")
    int insert(Test test)throws Exception;

    @Select("select id,name,sex,age from test where name=#{name}")
    Test selectOneByName(@Param("name") String name)throws Exception;

}
