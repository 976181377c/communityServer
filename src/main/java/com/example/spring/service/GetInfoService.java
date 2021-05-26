package com.example.spring.service;

import com.example.spring.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetInfoService {
    List<Questions> selectPortalPage(@Param("start")int start,@Param("page")int page);

    List<Questions> selectPortal(@Param("id")String id);

    List<reply> selectReply(@Param("id") String id, @Param("start")int start, @Param("page")int page);

    boolean selectLike(String uid, String qid,String bkid,String bid);

    boolean selectCollection(String uid, String qid,String bkid,String bid);

    List<Questions> getCollection(@Param("uid") String uid, @Param("start")int start,@Param("page")int page);

    List<Image> getAlbun(@Param("uid") String uid);

    List<Book>  bookPortal();

    List<Book>  bookPortal(String type);

    Book  selectBook(String id);

    Blog getBlog(String id);

    List<Blog> blogPortal(int start, int page);

    List<Blog> myBlog(String uid);

    Portal AllPortal();

    List<Questions> questionMain(String status,String title);

    List<Blog> blogMain(String status, String title);

    List<Book> bookMain(String status, String title);

    List<message> getMessage(String id);

    int countMessage(String uid);
}
