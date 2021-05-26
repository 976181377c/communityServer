package com.example.spring.controller;

import com.example.spring.bean.Blog;
import com.example.spring.bean.Questions;
import com.example.spring.service.GetInfoService;
import com.example.spring.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "*", maxAge = 3600)
public class InsertController {
    @Autowired
    InsertService insertService;

    @RequestMapping(value = "insertReply", method = RequestMethod.POST)
    public int insertReply(String qid, String uid, String html, String content) {
        return insertService.replyInsert(qid, uid, html,content);
    }

    @RequestMapping(value = "insertQuestion", method = RequestMethod.POST)
    public Questions insertQuestion(String uid, String title, String content, String html) {
        return insertService.questionInsert(uid, title, content, html);
    }

    @RequestMapping(value = "like", method = RequestMethod.POST)
    public String like(String uid, String qid,String bkid,String bid) {
        return insertService.like(uid, qid,bkid,bid);
    }

    @RequestMapping(value = "collection", method = RequestMethod.POST)
    public String collection(String uid, String qid,String bkid,String bid) {
        return insertService.collection(uid, qid,bkid,bid);
    }

    @RequestMapping(value = "replyInReply", method = RequestMethod.POST)
    public String replyInReply(String rid, String ruid, String uid, String rname, String context) {
        return insertService.replyInReply(rid, ruid, uid, rname, context);
    }
    @RequestMapping(value = "insertBlog", method = RequestMethod.POST)
    public Blog insertBlog(String uid, String title,String content, String html) {
        return insertService.insertBlog(uid,title,content,html);
    }

}
