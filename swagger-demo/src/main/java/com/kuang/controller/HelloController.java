package com.kuang.controller;

import com.kuang.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "helloController";
    }

    //只要我们的接口中，返回值存在实体类，就会被扫描到Swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //Operation接口，不是放在类上的，是对方法的解释
    @ApiOperation("hello2的接口注释")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("aa") User user){
        return user;
    }
}
