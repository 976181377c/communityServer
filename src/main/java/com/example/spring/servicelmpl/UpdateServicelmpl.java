package com.example.spring.servicelmpl;

import com.example.spring.mapper.GetInfoMapper;
import com.example.spring.mapper.UpdateMapper;
import com.example.spring.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class UpdateServicelmpl implements UpdateService {

    @Autowired
    private UpdateMapper updateMapper;

    @Override
    public String updateBlog(String id, String uid, String title, String content, String html) {
        int str = updateMapper.updateBlog(id, uid, title, content, html);
        updateMapper.blogChange("verify",id);
        return String.valueOf (str) ;
    }

    @Override
    public void replyCount(String id) {

    }

    @Override
    public String deletBlog(String id) {
        updateMapper.deletBlogColltion(id);
        updateMapper.deletBlogLike(id);
        updateMapper.deletBlog(id);
        return null;
    }

    @Override
    public String updateUserInfo(String uid, String background, String avatar, String introduction) {
        return updateMapper.updateUserInfo(uid,background,avatar,introduction);
    }

    @Override
    public String questionChange(String status,String id) {
        return String.valueOf(updateMapper.questionChange(status,id));
    }

    @Override
    public String blogChange(String status, String id) {
        return String.valueOf(updateMapper.blogChange(status,id));
    }

    @Override
    public String removeMessage(String uid) {
        return String.valueOf(updateMapper.removeMessage(uid));
    }
}
