package com.sakura.ofm.controller;

import com.alibaba.fastjson.JSON;
import com.sakura.ofm.annotation.OFM;
import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.model.PageVO;
import com.sakura.ofm.service.BlogService;
import com.sakura.ofm.tools.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author y14
 * @date 2018-10-30
 * @describe Default请求层
 */

@Controller
public class DefaultController {

    @Resource
    private BlogService ofmBlogService;

    @RequestMapping("/")
    public ModelAndView index(@RequestAttribute("base") String base){
        ModelAndView mv = new ModelAndView("index");
        PageBean<Blog> pageBean = ofmBlogService.getBolgForViewList(1,5);
        mv.addObject("base",base);
        mv.addObject("blogBean",pageBean);
        return mv;
    }

    @RequestMapping("/write")
    @OFM
    public ModelAndView write(@RequestAttribute("base") String base){
        ModelAndView mv = new ModelAndView("write");
        mv.addObject("base",base);
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestAttribute("base") String base){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("base",base);
        return mv;
    }

    @RequestMapping("/resume")
    public ModelAndView resume(@RequestAttribute("base") String base){
        ModelAndView mv = new ModelAndView("resume");
        mv.addObject("base",base);
        return mv;
    }


}
