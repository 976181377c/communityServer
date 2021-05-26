package com.example.spring.bean;

import lombok.Data;

@Data
public class Blog {
    private String id;
    private String uid;
    private String name;
    private String type;
    private int replies;
    private int collections;
    private int likes;
    private String avatar;
    private String title;
    private String content;
    private String html;
    private String status;
    private String create_time;
}
