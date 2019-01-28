package com.sakura.ofm.tools;

import com.sakura.ofm.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author y14
 * @date 2018-01-25
 * shiro工具包
 */
public class TokenHelper {

    //获取当前登录对象
    public static User getToken(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 用户登录
     * @param user 用户信息
     * @return
     */
    public static User login(User user){
        //将用户的账号密码转化成Realm需要的token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getMailAddress(),user.getPassword());
        /**
         * 执行此方法时,会先调用Realm中的doGetAuthenticationInfo方法（可以理解为登录验证），
         * 验证失败抛出异常，成功则会调用doGetAuthorizationInfo方法进行授权
         */
        SecurityUtils.getSubject().login(token);
        return getToken();
    }

    /**
     * 用户登出
     */
    public static void loginOut(){
        SecurityUtils.getSubject().logout();
    }
}
