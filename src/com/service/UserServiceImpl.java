package com.service;

import com.dao.UserMapper;
import com.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public void insertUser(User u) throws  Exception{
        userMapper.insertUser(u);

    }

    @Override
    public List<User> checkUser(String searchtext) throws Exception {
        if(searchtext==null || searchtext.equals(""))
        {
            return userMapper.checkAllUser();
        }
        else
        {

            return userMapper.checkUserByName(searchtext);
        }
    }
}
