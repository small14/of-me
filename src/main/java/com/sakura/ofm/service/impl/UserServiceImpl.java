package com.sakura.ofm.service.impl;

import com.sakura.ofm.dao.UserDao;
import com.sakura.ofm.entity.User;
import com.sakura.ofm.entity.UserExample;
import com.sakura.ofm.model.ResultVO;
import com.sakura.ofm.service.UserService;
import com.sakura.ofm.tools.EMailHelper;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private EMailHelper eMailHelper;


    @Override
    public ResultVO login(User user,String base) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();
        criteria.andMailAddressEqualTo(user.getMailAddress());
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andActivationEqualTo(new Byte("1"));
        List<User> userList = userDao.selectByExample(example);
        if (null != userList && userList.size()>0){
            User userMessage = userList.get(0);
//            userMessage.setPassword(null);
            ResultVO resultVO = new ResultVO();
            resultVO.setResultCode(ResultVO.SUCCESSCODE);
            resultVO.setResultMessage("登录成功");
            resultVO.setResultObject(userMessage);
            resultVO.setSuccessUrl(base);
            return resultVO;
        }else {
            ResultVO resultVO = new ResultVO();
            resultVO.setResultCode(ResultVO.FAILCODE);
            resultVO.setResultMessage("账号或密码错误");
            return resultVO;
        }

    }

    @Override
    public ResultVO register(User user,String base) {
        //TOOD加上邮件规则验证

        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();
        criteria.andMailAddressEqualTo(user.getMailAddress());
        List<User> userList = userDao.selectByExample(example);
        if (null != userList && userList.size()>0){
            ResultVO resultVO = new ResultVO();
            resultVO.setResultCode(ResultVO.FAILCODE);
            resultVO.setResultMessage("该邮箱已被注册...");
            return resultVO;
        }

        user.setUserId(UUID.randomUUID().toString());
        user.setRegistrationTime(new Date());
        userDao.insertSelective(user);
        eMailHelper.sendMail("OFM账号激活"
                ,"欢迎使用OFMblog，您的账号激活链接为:<a href=\""+base+"/user/activation?code="+user.getUserId()+"\">请点此激活账号</a>"
                ,new Date(),user.getMailAddress());
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCode(ResultVO.SUCCESSCODE);
        resultVO.setResultMessage("恭喜您注册成功！请注意查收邮件激活账号!");
        return resultVO;
    }


    @Override
    public ResultVO activation(String code) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();
        criteria.andUserIdEqualTo(code);
        List<User> userList = userDao.selectByExample(example);
        if (null != userList && userList.size()>0){
            User user = userList.get(0);
            user.setActivation(new Byte("1"));
            UserExample userExample = new UserExample();
            UserExample.Criteria userCritertia = userExample.createCriteria();
            userCritertia.andUserIdEqualTo(user.getUserId());
            userDao.updateByExampleSelective(user,userExample);
            ResultVO resultVO = new ResultVO();
            resultVO.setResultCode(ResultVO.SUCCESSCODE);
            resultVO.setResultMessage("恭喜您账号激活成功！");
            return resultVO;
        }
            ResultVO resultVO = new ResultVO();
            resultVO.setResultCode(ResultVO.FAILCODE);
            resultVO.setResultMessage("账号激活失败！请确认您的code是否正确！");
            return resultVO;
    }


    @Override
    public ResultVO shiroLogin(UsernamePasswordToken token) {
        User user = new User();
        user.setMailAddress(token.getUsername());
        user.setPassword(String.valueOf(token.getPassword()));
        return this.login(user,null);
    }
}
