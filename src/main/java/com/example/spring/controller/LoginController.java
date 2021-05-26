package com.example.spring.controller;

import com.example.spring.bean.Login;
import com.example.spring.bean.UserBean;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;


    @RequestMapping(value = "/sbwq", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String show(){
        return "sb王强";
    }

    @RequestMapping(value = "/getinfo",produces = {"application/json;charset=UTF-8"})
    @ResponseBody

    public List<UserBean> getInfo(){
        return  userService.select();
    }

    @PostMapping(value = "/loginIn")
    public Login login(String name, String password ){
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            try {
                final String id = userBean.getId();
                final Base64.Encoder encoder = Base64.getEncoder();
                final String text = "{\"uid\":\""+id+"\",\"name\":\""+name+"\"}";
                final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
                Login login = new Login();
                login.setToken(encoder.encodeToString(textByte));
                return login ;

            }catch (Exception e){
                return null;
            }
        }else {
            return null;
        }

    }
    ///registered
    @PostMapping(value = "/registered")
    public Login registered(String name, String password ){
        int i = userService.registered(name,password);
        if(i==1){
            UserBean userBean = userService.loginIn(name,password);
            if(userBean!=null){
                try {
                    final String id = userBean.getId();
                    final Base64.Encoder encoder = Base64.getEncoder();
                    final String text = "{\"uid\":\""+id+"\",\"name\":\""+name+"\"}";
                    final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
                    Login login = new Login();
                    login.setToken(encoder.encodeToString(textByte));
                    return login ;

                }catch (Exception e){
                    return null;
                }
            }else {
                return null;
            }
        }else {
            return null;
        }

    }
}