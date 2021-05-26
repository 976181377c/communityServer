package com.example.spring.servicelmpl;

import com.example.spring.bean.UserBean;
import com.example.spring.mapper.UserMapper;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }
    public List<UserBean> select(){
        return userMapper.select();
    }

    @Override
    public int registered(String name, String password) {
      UserBean userBean = userMapper.selectName(name);
      if(userBean==null){
          return userMapper.registered(name,password);
      }else {
          return  0;
      }
    }
}