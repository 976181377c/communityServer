package com.example.spring.bean;
import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String id;
    private String uid;
    private String title;
    private String type;
    private int replies;
    private int collections;
    private String author;
    private float  price;
    private String description;
    private String image;
    private String imageId;
    private String status;
    private List<bookReply> reply;
}
