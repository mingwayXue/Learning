package com.xue.demo.comment.mapper;

import java.util.List;

import com.xue.demo.comment.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CommentMapper {

  int insert(Comment comment);
  
  List<Comment> selectComments(@Param("houseId") long houseId, @Param("size") int size);
  
  List<Comment> selectBlogComments(@Param("blogId") long blogId, @Param("size") int size);
  
}

