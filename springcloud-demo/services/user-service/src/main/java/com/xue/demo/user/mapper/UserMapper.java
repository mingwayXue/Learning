package com.xue.demo.user.mapper;

import java.util.List;

import com.xue.demo.user.model.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper {
  
  User selectById(Long id);
  
  List<User> select(User user);
  
  int update(User user);
  
  int insert(User account);
  
  int delete(String email);
  
  User selectByEmail(String email);

}
