package com.example.demo720.domain.dao;

import com.example.demo720.domain.entity.User;
import org.apache.ibatis.annotations.*;

/***
 * @author zou
 */
@Mapper
public interface UserMapper {

    @Select("select id,name,password,phone from t_user where phone=#{phone}")
    User findUserByPhone(@Param("phone") String phone)throws Exception;

    @Insert("insert into t_user (name,password,phone) values (#{name},#{password},#{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone)throws Exception;

    @Select("select name from t_user where phone=#{phone}")
    String getUsernameByPhone(@Param("phone") String phone)throws Exception;
}
