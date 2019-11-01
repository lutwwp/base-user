package com.wwp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwp.demo.annotation.DecryptionAmount;
import com.wwp.demo.annotation.EncryptionAmount;
import com.wwp.demo.entity.User;
import com.wwp.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author wwp
 * @Date 2019-10-31
 * @Version V1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @DecryptionAmount
    public List<User> getUserList(){
        List<User> userList = userMapper.selectList(null);
        return userList;
    }
    @EncryptionAmount
    public Integer saveUser(User user){
        int insert = userMapper.insert(user);
        return insert;
    }
    @DecryptionAmount
    public List<User> getUserListByPage(){
        Page<User> page = new Page<>(3,4);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> records = userIPage.getRecords();
        return records;
    }
}
