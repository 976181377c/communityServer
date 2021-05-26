package com.example.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    private String id;
    private String uid;
    private String name;
    private String type;
    private int replies;
    private int collections;
    private int likes;
    private String title;
    private String avatar;
    private String description;
    private String content;
    private String status;
    private String html;
    private String create_time;


}
