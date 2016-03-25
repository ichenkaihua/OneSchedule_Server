package com.github.ichenkaihua.oneschedule.service;

import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chenkh on 16-3-20.
 */
@Service
public class UserService extends BaseService<UserMapper, User> {


    public void register(User user) {
        String salt = RandomStringUtils.randomAlphanumeric(10);
        user.setSalt(salt);
        user.setCreateTime(new Date());
        user.setLastTime(new Date());
        mapper.insert(user);
        User newUser = new User();

        String password = user.getPassword();
        Md5Hash md5Hash = new Md5Hash(password, password + user.getId() + salt);
        newUser.setId(user.getId());
        newUser.setPassword(md5Hash.toString());
        mapper.updateByPrimaryKeySelective(newUser);
    }


    public User getUserByPhonePassword(String phone, String password) {
        User queryUser = new User();
        queryUser.setPhone(phone);
        List<User> select = mapper.select(queryUser);
        User user = select.get(0);
        String userPassword = user.getPassword();
        String salt = user.getSalt();
        Md5Hash md5Hash = new Md5Hash(password, password + user.getId() + salt);
        if(md5Hash.toString().equals(userPassword)){
            return user;
        }else return null;
    }


    public User getUserById(int id) {
        return selectByPrimaryKey(id);
    }


    public boolean hasRegister(String phone) {
        User queryUser = new User();
        queryUser.setPhone(phone);
        return selectCount(queryUser) > 0;
    }


    public User addUser(String phone, String password) {


        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        register(user);
        return user;
    }


}
