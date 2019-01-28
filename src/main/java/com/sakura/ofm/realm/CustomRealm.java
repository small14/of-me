package com.sakura.ofm.realm;

import com.sakura.ofm.entity.Author;
import com.sakura.ofm.entity.User;
import com.sakura.ofm.model.ResultVO;
import com.sakura.ofm.service.UserAuthorService;
import com.sakura.ofm.service.UserService;
import com.sakura.ofm.tools.TokenHelper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author  y14
 * @date 2019-01-25
 * shiro realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthorService userAuthorService;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = TokenHelper.getToken();
        List<Author> authorList = userAuthorService.queryUserAuthor(user.getUserId());

        //此处只设置了用户权限 没有设置角色 因为项目较小就不设置角色分类了
        Set<String> set = new HashSet<>();
        for (Author author:authorList){
            set.add(author.getAuthorCode());
        }
        //创建用户的权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(set);
        return info;
    }


    /**
     * 身份认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ResultVO resultVO =  userService.shiroLogin(token);
        if (resultVO.getResultCode()==ResultVO.SUCCESSCODE){
            User loginUser = (User) resultVO.getResultObject();
            return new SimpleAuthenticationInfo(loginUser,loginUser.getPassword(),getName());
        }else {
            throw new AccountException("账号或者密码不正确！");
        }
    }
}
