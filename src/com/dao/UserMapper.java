package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface UserMapper {
    public void insertUser(User u) throws  Exception;

    List<User> checkAllUser()throws  Exception;

  public    List<User> checkUserByName(@Param("searchtext")String searchtext) throws  Exception;
}
