package com.example.spring.mapper;

import com.example.spring.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    UserBean getInfo( @Param("name")String name,@Param("password") String password);
    List<UserBean> select();

    @Insert("insert into user_info (name,password) values (#{name},#{password})")
    int registered(String name, String password);
    @Select("select * from user_info as u where name = #{name}")
    UserBean selectName(String name);
}
