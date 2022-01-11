package com.kuang.config;

import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm  extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了---->授权doGetAuthorizationInfo");

        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//拿到User对象

        //设置当前权限
        info.addStringPermission(currentUser.getPerms());

//        return null;
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了---->认证doGetAuthenticationInfo");

//        //用户名
//        String name = "root";
//        String password = "123";



        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //连接真实数据库
        User user = userService.queryUserName(userToken.getUsername());

        if(user == null){
            return null;//抛出异常    UnknownAccountException
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //密码加密  md5：xxxxxx   md5盐值加密:xxxxxxusername
        //密码认证 ，shiro做
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");

    }
}
