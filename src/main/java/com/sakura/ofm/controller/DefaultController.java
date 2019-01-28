package com.sakura.ofm.controller;

import com.sakura.ofm.annotation.OFM;
import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.model.DefaultResponseModel;
import com.sakura.ofm.service.BlogService;
import com.sakura.ofm.tools.PageBean;
import com.sakura.ofm.tools.TokenHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author y14
 * @date 2018-10-30
 * @describe Default请求层
 */

@Controller
public class DefaultController {

    @Resource
    private BlogService ofmBlogService;

    //默认跳转
    @RequestMapping("/")
    public ModelAndView index(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        ModelAndView mv = new ModelAndView("index");
        PageBean<Blog> pageBean = ofmBlogService.getBolgForViewList(1,5);
        mv.addObject("responseModel",responseModel);
        mv.addObject("blogBean",pageBean);
        if (null != TokenHelper.getToken()){
            responseModel.setLogin(true);
        }
        return mv;
    }

    //用户登录页面
    @RequestMapping("/login")
    public ModelAndView login(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("responseModel",responseModel);
        if (null != TokenHelper.getToken()){
            responseModel.setLogin(true);
        }
        return modelAndView;
    }

    @RequestMapping("/private/write")
    @OFM(value = "admin")
    public ModelAndView write(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        ModelAndView mv = new ModelAndView("write");
        mv.addObject("responseModel",responseModel);
        return mv;
    }

    @RequestMapping("/private/editor")
    @OFM(value = "admin")
    public ModelAndView editor(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        ModelAndView mv = new ModelAndView("editor");
        mv.addObject("responseModel",responseModel);
        return mv;
    }


    @RequestMapping("/resume")
    public ModelAndView resume(@RequestAttribute("responseModel") DefaultResponseModel responseModel){
        ModelAndView mv = new ModelAndView("resume");
        mv.addObject("responseModel",responseModel);
        return mv;
    }



}
