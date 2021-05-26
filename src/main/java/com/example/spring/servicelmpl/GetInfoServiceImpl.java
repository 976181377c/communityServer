package com.example.spring.servicelmpl;

import com.example.spring.bean.*;
import com.example.spring.mapper.GetInfoMapper;
import com.example.spring.service.GetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetInfoServiceImpl implements GetInfoService {
    @Autowired
    private GetInfoMapper getInfoMapper;

    @Override
    public List<Questions> selectPortalPage(int start, int page) {
        return getInfoMapper.selectPortalPage(start, page);
    }

    public List<Questions> selectPortal(String id) {
        return getInfoMapper.selectQuestion(id);
    }

    public List<reply> selectReply(String id, int start, int page) {
        return getInfoMapper.selectReply(id, start, page);
    }

    @Override
    public boolean selectLike(String uid,String qid,String bkid,String bid) {
        if (getInfoMapper.selectLike(uid,qid,bkid,bid) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean selectCollection(String uid, String qid,String bkid,String bid) {
        if (getInfoMapper.selectCollection(uid, qid,bkid,bid) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Questions> getCollection(String uid, int start, int page) {
        return getInfoMapper.getCollection(uid, start, page);
    }

    @Override
    public List<Image> getAlbun(String uid) {
        return getInfoMapper.getAlbun(uid);
    }

    @Override
    public List<Book> bookPortal() {
        return getInfoMapper.bookPortal();
    }

    @Override
    public List<Book> bookPortal(String type) {
        return null;
    }

    @Override
    public Book selectBook(String id) {
        Book book = getInfoMapper.selectBook(id);
        if (book.getId() != null) {
            book.setReply(getInfoMapper.selectBookReply(id));
        }
        return book;
    }

    @Override
    public Blog getBlog(String id) {
        return getInfoMapper.getBlog(id);
    }

    @Override
    public List<Blog> blogPortal(int start, int page) {
        return getInfoMapper.blogPortal(start, page);
    }

    @Override
    public List<Blog> myBlog(String uid) {
        return getInfoMapper.myBlog(uid);
    }

    @Override
    public Portal AllPortal() {
        List<Questions> questions = getInfoMapper.randQuestions();
        List<Blog> Blog = getInfoMapper.randBlog();
        List<Book> Book = getInfoMapper.randBook();
        Portal portal = new Portal();
        portal.setQuestions(questions);
        portal.setBlog(Blog);
        portal.setBooks(Book);
        return portal;
    }

    @Override
    public List<Questions> questionMain(String status, String title) {
        return getInfoMapper.questionMain(status,title);}

    @Override
    public List<Blog> blogMain(String status, String title) {
        return getInfoMapper.blogMain(status, title);
    }

    @Override
    public List<Book> bookMain(String status, String title) {
        return getInfoMapper.bookMain(status, title);
    }

    @Override
    public List<message> getMessage(String id) {
        return getInfoMapper.getMessage(id);
    }

    @Override
    public int countMessage(String uid) {
       List<countMessage> messages =  getInfoMapper.countMessage(uid);
       countMessage message = messages.get(0);
        return message.getCount();
    }

}
