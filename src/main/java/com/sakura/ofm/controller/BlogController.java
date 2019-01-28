package com.sakura.ofm.controller;

import com.sakura.ofm.annotation.OFM;
import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.model.DefaultResponseModel;
import com.sakura.ofm.model.ResultVO;
import com.sakura.ofm.service.BlogService;
import com.sakura.ofm.tools.PageBean;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author y14
 * @date 2018-10-30
 * @describe 博客文章相关请求层
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService ofmBlogService;

    @RequestMapping("/article")
    public ModelAndView articleView(@RequestAttribute("responseModel") DefaultResponseModel responseModel, @RequestParam("id") Long id){
        ModelAndView mv =  new ModelAndView("article");
        Blog blog = ofmBlogService.getBlogById(id);
        mv.addObject("responseModel",responseModel);
        mv.addObject("article",blog);
        return mv;
    }


    @RequestMapping("/bloglist")
    public ModelAndView blogList(@RequestAttribute("responseModel") DefaultResponseModel responseModel,@RequestParam("pageNum") int pageNum){
        PageBean<Blog> pageBean = ofmBlogService.getBolgForViewList(pageNum,5);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("responseModel",responseModel);
        mv.addObject("blogBean",pageBean);
        return mv;
    }

    @RequestMapping("/private/saveblog")
    @ResponseBody
    public Object saveBlog(@RequestAttribute("responseModel") DefaultResponseModel responseModel,@RequestParam("content") String content,@RequestParam("title") String title){
        ofmBlogService.saveBlog(content,title);
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessUrl(responseModel.getBaseUrl());
        resultVO.setResultCode(resultVO.SUCCESSCODE);
        resultVO.setResultMessage("save blog success");
        resultVO.setSuccessUrl(responseModel.getBaseUrl());
        return resultVO;
    }

    @RequiresAuthentication
    @RequestMapping("/private/delete")
    public ModelAndView saveBlog(@RequestAttribute("responseModel") DefaultResponseModel responseModel,@RequestParam("id") Long blogId){
        ofmBlogService.deleteBlog(blogId);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

}
