package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
     public  void insertUser(User u)throws  Exception;

     List<User> checkUser(String searchtext) throws Exception;
}
