package com.github.ichenkaihua.oneschedule.service;

import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by chenkh on 16-3-20.
 */
@Service
public class UserService extends BaseService<UserMapper,User> {



    public User getUserById(int id) {
        return selectByPrimaryKey(id);
    }


    public boolean hasRegister(String phone){
        User queryUser = new User();
        queryUser.setPhone(phone);
        return selectCount(queryUser)>0;
    }


    public User addUser(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        Date date = new Date();
        user.setCreateTime(date);
        user.setLastTime(date);
        mapper.insert(user);
        return user;
    }


}
