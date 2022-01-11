package com.pxy.mapper;


import com.pxy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解表示了这是一个 mybatis 的 mapper 类
@Mapper//注意这里的mapper使用的apache的
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
