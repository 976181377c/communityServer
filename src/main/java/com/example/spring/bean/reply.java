package com.example.spring.bean;
import lombok.Data;

import java.util.List;

@Data

public class reply {
    private String id;
    private String qid;
    private String uid;
    private String name;
    private String avatar;
    private String html;
    private String create_time;
    private List<replyInReply> reply;
}
