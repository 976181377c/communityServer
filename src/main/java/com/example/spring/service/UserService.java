package com.example.spring.service;

import com.example.spring.bean.UserBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserBean loginIn(String name, String password);
    List<UserBean> select();

    int registered(String name, String password);
}
