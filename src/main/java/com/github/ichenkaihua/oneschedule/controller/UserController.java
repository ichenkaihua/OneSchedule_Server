package com.github.ichenkaihua.oneschedule.controller;

import com.github.ichenkaihua.oneschedule.bean.BaseResponse;
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
            return BaseResponse.buildSuccessResponse(user).toResponseEntity();
        } else {
            return BaseResponse.buildFailResponse(Status.STATUS_1, "您已注册过，无需重写注册").toResponseEntity();
        }

    }


    /**
     * 登陆用户
     *
     * @param phone    电话号码
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "{phone}", method = RequestMethod.GET,params = "password")
    public ResponseEntity login(@PathVariable String phone, @RequestParam String password) {

        if (!userService.hasRegister(phone)) {
            return BaseResponse.buildFailResponse(Status.STATUS_1, "你还没有注册").toResponseEntity();
        } else {
            User user = userService.getUserByPhonePassword(phone, password);
            List<User> select = userService.select(user);
            if (select == null) {
                return BaseResponse.buildFailResponse(Status.STATUS_2, "密码不正确").toResponseEntity();
            }
            return BaseResponse.buildSuccessResponse(select.get(0)).toResponseEntity();
        }
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable int id) {
        return BaseResponse.buildSuccessResponse(userService.getUserById(id)).toResponseEntity();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        return BaseResponse.buildSuccessResponse(userService.selectAll()).toResponseEntity();
    }


}
