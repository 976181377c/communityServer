package com.example.spring.bean;

import lombok.Data;

import java.util.List;
@Data
public class Portal {
    private List<Questions> questions;
    private List<Blog> blog;
    private List<Book> books;
}
