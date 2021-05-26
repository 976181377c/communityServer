package com.example.spring.controller;

import com.example.spring.bean.*;
import com.example.spring.service.GetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GetInfoController {

    //将Service注入Web层
    @Autowired
    GetInfoService getInfoService;

    @RequestMapping(value = "/portal", method = RequestMethod.GET) //主页
    public List<Questions> getPortal(String id, String start, String page) {
        if (id != null) {
            return getInfoService.selectPortal(id);
        }
        return getInfoService.selectPortalPage(Integer.valueOf(start), Integer.valueOf(page));

    }

    @RequestMapping(value = "/reply")
    public List<reply> getReply(String id, int start, int page) {

        return getInfoService.selectReply(id, start, page);
    }

    @RequestMapping(value = "/getOperation")
    public Operation getOperation(String uid,String qid,String bkid,String bid) {
        Operation operation = new Operation();
        operation.setLike(getInfoService.selectLike(uid,qid,bkid,bid));
        operation.setCollection(getInfoService.selectCollection(uid,qid,bkid,bid));
        return operation;
    }

    @RequestMapping(value = "/getCollection")
    public List<Questions> getCollection(String uid, int start, int page) {
        return getInfoService.getCollection(uid, start, page);
    }

    @RequestMapping(value = "/getAlbun")
    public List<Image> getAlbun(String uid) {
        return getInfoService.getAlbun(uid);
    }

    @RequestMapping(value = "/bookPortal", method = RequestMethod.GET)
    public List<Book> bookPortal(String type) {
        if (type != null) {
            return getInfoService.bookPortal(type);
        }
        return getInfoService.bookPortal();

    }

    @RequestMapping(value = "/selectBook", method = RequestMethod.GET)
    public Book selectBook(String id) {
        return getInfoService.selectBook(id);
    }

    @RequestMapping(value = "/getBlog", method = RequestMethod.GET)
    public Blog getBlog(String id) {
        return getInfoService.getBlog(id);
    }

    @RequestMapping(value = "/blogPortal", method = RequestMethod.GET)
    public List<Blog> blogPortal(int start, int page) {
        return getInfoService.blogPortal(start, page);
    }

    @RequestMapping(value = "/myBlog", method = RequestMethod.GET)
    public List<Blog> blogPortal(String uid) {
        return getInfoService.myBlog(uid);
    }

    @RequestMapping(value = "/AllPortal", method = RequestMethod.GET)
    public Portal AllPortal(String uid) {
        return getInfoService.AllPortal();
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public List<message> getMessage(String id) {
        return getInfoService.getMessage(id);
    }

    @RequestMapping(value = "/countMessage", method = RequestMethod.GET)
    public int countMessage(String uid) {
        return getInfoService.countMessage(uid);
    }
    //////////////////////////////////main//////////////////////////////////
    @RequestMapping(value = "/questionMain", method = RequestMethod.GET)
    public List<Questions> questionMain(String status,String title) {
        return getInfoService.questionMain(status,title);
    }
    @RequestMapping(value = "/blogMain", method = RequestMethod.GET)
    public List<Blog> blogMain(String status,String title) {
        return getInfoService.blogMain(status,title);
    }

    @RequestMapping(value = "/bookMain", method = RequestMethod.GET)
    public List<Book> bookMain(String status,String title) {
        return getInfoService.bookMain(status,title);
    }




}