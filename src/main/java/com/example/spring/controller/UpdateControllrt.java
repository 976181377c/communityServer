package com.example.spring.controller;

import com.example.spring.bean.Blog;
import com.example.spring.service.GetInfoService;
import com.example.spring.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@CrossOrigin(origins = "*", maxAge = 3600)
public class UpdateControllrt {

    @Autowired
    UpdateService updateService;

    @RequestMapping(value = "/updateBlog",method = RequestMethod.POST)
    public String blogPortal(String id ,String uid, String title,String content, String html){
        return updateService.updateBlog(id,uid,title,content,html);
    }
    @RequestMapping(value = "/deletBlog",method = RequestMethod.POST)
    public String deletBlog(String id ){
        return updateService.deletBlog(id);
    }
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String insertBlog(String uid, String background,String avatar, String introduction) {
        return updateService.updateUserInfo(uid,background,avatar,introduction);
    }
    //
    @RequestMapping(value = "/questionChange", method = RequestMethod.POST)
    public String questionChange(String status,String id) {
        return updateService.questionChange(status,id);
    }
    @RequestMapping(value = "/blogChange", method = RequestMethod.POST)
    public String blogChange(String status,String id) {
        return updateService.blogChange(status,id);
    }
    //removeMessage
    @RequestMapping(value = "/removeMessage", method = RequestMethod.POST)
    public String removeMessage(String uid) {
        return updateService.removeMessage(uid);
    }
}
