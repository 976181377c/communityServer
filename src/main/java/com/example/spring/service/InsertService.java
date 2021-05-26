package com.example.spring.service;

import com.example.spring.bean.Blog;
import com.example.spring.bean.Questions;
import org.apache.ibatis.annotations.Param;

public interface InsertService {
    int replyInsert(String qid,String uid,String html,String content);

    Questions questionInsert(@Param("uid") String uid, @Param("title") String title, @Param("content") String content, @Param("html") String html);

    String like(String uid, String qid,String bkid,String bid);

    String collection(String uid, String qid,String bkid,String bid);

    String replyInReply(String rid, String ruid,String uid, String rname, String context);

    Blog insertBlog(String uid, String title, String content, String html);

    String insertMessage(String qid,String uid,String ruid,String rname,String content);
}
