package com.github.ichenkaihua.oneschedule.service;

import com.github.ichenkaihua.oneschedule.compoment.SpringContextUtil;
import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.Date;
import java.util.List;

/**
 * Created by chenkh on 16-3-20.
 */
@Service
public class UserService extends BaseService<UserMapper, User> {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);


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
        if (md5Hash.toString().equals(userPassword)) {
            return user;
        } else return null;
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


    public void uploadFIle(MultipartFile[] files) throws IOException {
        String servletContextRealPath = SpringContextUtil.getServletContextRealPath();
        logger.debug("files size="+files.length);

        for (MultipartFile file : files) {
            logger.debug("file name"+file.getOriginalFilename());
            logger.debug("file type:"+file.getContentType());
            logger.debug("file size:"+file.getSize());
            File toFile = new File(servletContextRealPath+"/image"+file.getOriginalFilename());
            file.transferTo(toFile);
            logger.debug("toFile path:"+toFile.getAbsolutePath());
        }





    }


}
