package com.github.ichenkaihua.oneschedule.service;

import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenkh on 16-3-20.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;



    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);

    }




}
