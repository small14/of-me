package com.sakura.ofm.controller;

import com.sakura.ofm.entity.User;
import com.sakura.ofm.model.DefaultResponseModel;
import com.sakura.ofm.model.ResultVO;
import com.sakura.ofm.service.UserService;
import com.sakura.ofm.tools.TokenHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    private  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultVO login(@RequestAttribute("responseModel") DefaultResponseModel responseModel, @RequestBody User user, HttpServletRequest request) {
        User loginUser = null;
        try {
            loginUser = TokenHelper.login(user);
        }catch (AccountException e){
            logger.info("用户登录失败");
        }

        ResultVO resultVO = new ResultVO();
        if (null != loginUser){
            resultVO.setResultCode(ResultVO.SUCCESSCODE);
            resultVO.setSuccessUrl(responseModel.getBaseUrl());
        }else {
            resultVO.setResultCode(ResultVO.FAILCODE);
        }
        return resultVO;
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResultVO register(@RequestAttribute("responseModel") DefaultResponseModel responseModel, @RequestBody User user){
        return userService.register(user,responseModel.getBaseUrl());
    }

    @GetMapping("/activation")
    @ResponseBody
    private ResultVO activation(@RequestAttribute("responseModel") DefaultResponseModel responseModel,@RequestParam("code") String code){

        return userService.activation(code);
    }

    @RequestMapping("/loginOut")
    private ModelAndView  loginOut(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        TokenHelper.loginOut();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
}
