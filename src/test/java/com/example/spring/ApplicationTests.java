package com.example.spring;

import com.example.spring.bean.UserBean;
import com.example.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {

    }

}
