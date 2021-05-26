package com.example.spring.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UpdateMapper {
    void replyCount(@Param("id") String id );

    @Update("update blog set title=#{title},content=#{content},html=#{html} where id=#{id} and uid=#{uid}")
    int updateBlog(String id, String uid, String title, String content, String html);
    @Delete("delete from blog where bid=#{id}")
    String deletBlog(String id);
    @Delete("delete from colltion where bid=#{id}")
    String deletBlogColltion(String id);
    @Delete("delete from `like` where bid=#{id}")
    String deletBlogLike(String id);

    @Update("update user_info set background=#{background},avatar=#{avatar},introduction=#{introduction} where uid=#{uid}")
//    @Options(useGeneratedKeys = true, keyProperty = "uid")
    String updateUserInfo(String uid, String background, String avatar, String introduction);
    @Update("update questions set status = #{status}  where id=#{id}")
    int questionChange(String status,String id);

    @Update("update blog set status = #{status}  where id=#{id}")
    int blogChange(String status, String id);

    @Update("update message set readed = 0 where ruid = #{uid}")
    int removeMessage(String uid);
}
