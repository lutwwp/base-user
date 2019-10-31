package com.wwp.demo.controller;

import com.wwp.demo.entity.User;
import com.wwp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author wwp
 * @Date 2019-10-31
 * @Version V1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUserList")
    public List<User> getUserList(){
        List<User> userList = userService.getUserList();
        return userList;
    }

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public Integer saveUser(User user){
        int insert = userService.saveUser(user);
        return insert;
    }
}
