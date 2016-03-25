package com.github.ichenkaihua.oneschedule.controller;

import com.github.ichenkaihua.oneschedule.constance.Status;
import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenkh on 16-3-20.
 */

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    UserService userService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity register(@RequestParam String phone, @RequestParam String password) {
        if (!userService.hasRegister(phone)) {
            User user = userService.addUser(phone, password);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(Status.STATUS_1).build();
        }

    }


    /**
     * 登陆用户
     * @param phone 电话号码
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam String phone,@RequestParam String password) {

        if (!userService.hasRegister(phone)) {
            return ResponseEntity.status(Status.STATUS_1).build();
        } else {
            User user = userService.getUserByPhonePassword(phone, password);
            List<User> select = userService.select(user);
            if (select == null ) {
                return ResponseEntity.status(Status.STATUS_2).build();
            }
            return ResponseEntity.ok(select.get(0));
        }
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }


}
