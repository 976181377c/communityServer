package com.example.spring.mapper;

import com.example.spring.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetInfoMapper {
    List<Questions> selectPortalPage(@Param("start") int start, @Param("page") int page);

    List<Questions> selectQuestion(@Param("id") String id);

    List<reply> selectReply(@Param("id") String id, @Param("start") int start, @Param("page") int page);

    @Select({"<script>",
            "select * from `like`",
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
    String selectLike(String uid, String qid,String bkid,String bid);
    @Select({"<script>",
            "select * from `collection`",
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
    String selectCollection(String uid, String qid,String bkid,String bid);

    @Select("SELECT q.id,u.`name`,u.avatar,q.title,q.content,c.create_time FROM questions AS q,collection AS c,user_info AS u WHERE  c.uid = #{uid} GROUP BY q.id LIMIT #{start},#{page}")
    List<Questions> getCollection(@Param("uid") String uid, @Param("start") int start, @Param("page") int page);

    @Select("SElECT * FROM images WHERE uid = #{uid}")
    List<Image> getAlbun(@Param("uid") String uid);

    List<replyInReply> getReplyInReply(@Param("id") String id);

    @Select("SELECT * FROM books")
    List<Book> bookPortal();

    @Select("SELECT * FROM books WHERE id= #{id}")
    Book selectBook(String id);

    @Select("SELECT *,u.name,u.avatar FROM book_reply as b,user_info as u WHERE bid = #{id} AND b.uid = u.uid ")
    List<bookReply> selectBookReply(String id);

    @Select("SELECT b.*,u.`name`,u.avatar FROM blog as b,user_info as u where b.id = #{id} and b.uid = u.uid")
    Blog getBlog(String id);

    @Select("SELECT * FROM BlogView where   status ='normal' LIMIT #{start},#{page} ")
    List<Blog> blogPortal(int start, int page);

    @Select("SELECT b.*,u.`name`,u.avatar FROM blog as b,user_info as u where b.uid = u.uid and b.uid = #{uid}")
    List<Blog> myBlog(String uid);

    @Select("select *,'question' as type from questionView where status = 'normal' order by rand() limit 2 ")
    List<Questions> randQuestions();

    @Select("select *,'blog' as type from BlogView  where 1 order by rand() limit 2 ")
    List<Blog> randBlog();

    @Select("select *,'book' as type from BookView  where 1 order by rand() limit 1")
    List<Book> randBook();

    @Select({"<script>",
            "SELECT * FROM questionView",
            "WHERE 1=1",
            "<when test='status!=null'>",
            "AND status = #{status}",
            "</when>",
            "<when test='title!=null'>",
            "AND title like '%${title}%'",
            "</when>",
            "</script>"})
    List<Questions> questionMain(String status,String title);

    @Select({"<script>",
            "SELECT * FROM BlogView",
            "WHERE 1=1",
            "<when test='status!=null'>",
            "AND status = #{status}",
            "</when>",
            "<when test='title!=null'>",
            "AND title like '%${title}%'",
            "</when>",
            "</script>"})

    List<Blog> blogMain(String status, String title);

    @Select({"<script>",
            "SELECT * FROM BookView",
            "WHERE 1=1",
            "<when test='status!=null'>",
            "AND status = #{status}",
            "</when>",
            "<when test='title!=null'>",
            "AND title like '%${title}%'",
            "</when>",
            "</script>"})
    List<Book> bookMain(String status, String title);

    @Select("select * from reply where id=#{rid}")
    List<reply> selectReplyOne(String rid);


    List<message> getMessage(String id);

    @Select("select *,COUNT(id) as count from message where ruid = #{uid} and readed = 1")
    List<countMessage> countMessage(String uid);


//    Questions questionMain();
}
