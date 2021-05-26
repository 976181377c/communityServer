package com.example.spring.servicelmpl;

import com.example.spring.bean.Blog;
import com.example.spring.bean.Questions;
import com.example.spring.bean.reply;

import com.example.spring.mapper.GetInfoMapper;
import com.example.spring.mapper.InsertMapper;
import com.example.spring.service.InsertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InsertServiceImpl implements InsertService {
    @Autowired
    private InsertMapper insertMapper;
    @Autowired
    private GetInfoMapper getInfoMapper;

    @Override
    public int replyInsert(String qid, String uid, String html ,String content) {
        List<Questions> questions = getInfoMapper.selectQuestion(qid);
        if( questions.size() !=0){
            Questions question = questions.get(0);
            this.insertMessage(question.getId(),uid,question.getUid(),question.getName(),html);
        }
        return insertMapper.replyInsert(qid,uid,html);
    }
    @Override
    public Questions questionInsert(String uid, String title, String content, String html) {
        Questions questions = new Questions();
        questions.setUid(uid);
        questions.setTitle(title);
        questions.setContent(content);
        questions.setHtml((html));
        insertMapper.questionInsert(questions);
        String qid = questions.getId();
        this.like("3",qid,null,null);
        this.collection("3",qid,null,null);
        this.replyInsert(qid,uid,html,content);
        return questions;
    }
    @Override
    public String like(String uid, String qid,String bkid,String bid) {
        String id  = getInfoMapper.selectLike(uid,qid,bkid,bid);
        if(id==null){
            return String.valueOf(insertMapper.like(uid,qid,bkid,bid)) ;
        }
        return String.valueOf(insertMapper.delLike(uid,qid,bkid,bid));
    }

    @Override
    public String collection(String uid, String qid,String bkid,String bid) {
        String id = getInfoMapper.selectCollection(uid,qid,bkid,bid);
        if(id==null){
            return String.valueOf(insertMapper.collection(uid,qid,bkid,bid));
        }
        return String.valueOf(insertMapper.delcollection(uid,qid,bkid,bid));
    }

    @Override
    public String replyInReply(String rid, String ruid, String uid, String rname, String context) {
        List<reply> replyList = getInfoMapper.selectReplyOne(rid);
        reply reply = replyList.get(0);
        this.insertMessage(reply.getQid(),uid,ruid,rname,context);
        return  String.valueOf(insertMapper.replyInReply(rid,ruid,uid,rname,context));
    }

    @Override
    public Blog insertBlog(String uid, String title, String content, String html) {
        Blog blog = new Blog();
        blog.setUid(uid);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setHtml(html);
        insertMapper.insertBlog(blog);
        String id = blog.getId();
        this.like("3",null,null,id);
        this.collection("3",null,null,id);
        return blog;
    }

    @Override
    public String insertMessage(String qid,String uid,String ruid,String rname,String content){
        if(Integer.valueOf(uid).equals(Integer.valueOf(ruid))){
            return null;
        }
        return  String.valueOf(insertMapper.insertMessage(qid,uid,ruid,rname,content));
    }


}
