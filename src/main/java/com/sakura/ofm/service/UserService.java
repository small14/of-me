package com.sakura.ofm.service;

import com.sakura.ofm.entity.User;
import com.sakura.ofm.model.ResultVO;
import org.apache.shiro.authc.UsernamePasswordToken;

public interface UserService {

    //用户登录
    ResultVO login(User user,String base);
    //用户注册
    ResultVO register(User user,String base);
    //用户激活
    ResultVO activation(String code);
    //shiro登录
    ResultVO shiroLogin(UsernamePasswordToken token);
}
