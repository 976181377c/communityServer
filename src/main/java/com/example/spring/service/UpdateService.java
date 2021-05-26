package com.example.spring.service;

import com.example.spring.bean.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateService {
    String updateBlog(String id, String uid, String title, String content, String html) ;

    void replyCount(@Param("id") String id );

    String deletBlog(String id);

    String updateUserInfo(String uid, String background, String avatar, String introduction);

    String questionChange(String status,String id);

    String blogChange(String status, String id);

    String removeMessage(String uid);
}
