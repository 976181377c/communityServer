package com.example.spring.mapper;

import com.example.spring.bean.Blog;
import com.example.spring.bean.Questions;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InsertMapper {
    int replyInsert(@Param("qid") String qid, @Param("uid")String uid, @Param("html") String html);
//
//    @Insert("IN SERT INTO questions (uid, title, content, html) values (#{uid},#{title},#{content},#{html})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void questionInsert(Questions questions);

    @Insert("INSERT INTO `like`(uid,qid,bkid,bid) values(#{uid},#{qid},#{bkid},#{bid})")
    int like(String uid, String qid,String bkid,String bid);
    @Delete({"<script>",
            "delete from `like`",
            "WHERE uid=#{uid} ",
            "<when test='qid!=null'>",
            "and qid = #{qid}",
            "</when>",
            "<when test='bkid!=null'>",
            "and bkid = #{bkid}",
            "</when>",
            "<when test='bid!=null'>",
            "and bid = #{bid}",
            "</when>",
            "</script>"})
    int delLike(String uid, String qid,String bkid,String bid);

    @Insert("INSERT INTO `collection`(uid,qid,bkid,bid) values(#{uid},#{qid},#{bkid},#{bid})")
    int collection(String uid, String qid,String bkid,String bid);

    @Delete({"<script>",
            "delete from `collection`",
            "WHERE uid=#{uid} ",
            "<when test='qid!=null'>",
            "and qid = #{qid}",
            "</when>",
            "<when test='bkid!=null'>",
            "and bkid = #{bkid}",
            "</when>",
            "<when test='bid!=null'>",
            "and bid = #{bid}",
            "</when>",
            "</script>"})
    int delcollection(String uid, String qid,String bkid,String bid);

    int saveImage(@Param("uid") String uid,@Param("address") String address);

    @Insert("insert into blog (uid,title,content,html) values (#{uid},#{title},#{content},#{html})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBlog(Blog blog);

    @Insert("insert into replay_in_replay (rid,ruid,uid,rname,content) values (#{rid},#{ruid},#{uid},#{rname},#{context})")
    int replyInReply(String rid, String ruid,String uid, String rname, String context);

    @Insert("insert into message (qid,uid,ruid,rname,content) values (#{qid},#{uid},#{ruid},#{rname},#{content})")
    int insertMessage(String qid,String uid,String ruid,String rname,String content);

}
