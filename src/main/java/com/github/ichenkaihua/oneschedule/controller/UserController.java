package com.github.ichenkaihua.oneschedule.controller;

import com.github.ichenkaihua.oneschedule.entity.User;
import com.github.ichenkaihua.oneschedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenkh on 16-3-20.
 */

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }


}
