package com.pxy.controller;

import com.pxy.mapper.UserMapper;
import com.pxy.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/queryUserList")
//    @ResponseBody
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/queryUserById")
    @ApiImplicitParam(name="id",value="用户id",dataType="Integer")
    public User queryUserById(Integer id){
        User user = userMapper.queryUserById(id);
        System.out.println(user);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(@ApiParam("用户信息") User user){
        userMapper.addUser(user);
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(@ApiParam("用户信息") User user){
        userMapper.updateUser(user);
        return "ok";
    }

    @GetMapping("/deleteUser")
    @ApiImplicitParam(name="id",value="用户id",dataType="Integer")
    public String deleteUser( Integer id){
        userMapper.deleteUser(id);
        return "ok";
    }



}
