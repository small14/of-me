package com.sakura.ofm.controller;

import com.sakura.ofm.annotation.OFM;
import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.model.PageVO;
import com.sakura.ofm.model.ResultVO;
import com.sakura.ofm.service.BlogService;
import com.sakura.ofm.tools.PageBean;
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
    public ModelAndView articleView(@RequestAttribute("base") String base, @RequestParam("id") Long id){
        ModelAndView mv =  new ModelAndView("article");
        Blog blog = ofmBlogService.getBlogById(id);
        mv.addObject("base",base);
        mv.addObject("article",blog);
        return mv;
    }


    @RequestMapping("/bloglist")
    public ModelAndView blogList(@RequestAttribute("base") String base,@RequestParam("pageNum") int pageNum){
        PageBean<Blog> pageBean = ofmBlogService.getBolgForViewList(pageNum,5);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("base",base);
        mv.addObject("blogBean",pageBean);
        return mv;
    }

    @RequestMapping("/saveblog")
    @ResponseBody
    @OFM
    public Object saveBlog(@RequestAttribute("base") String base,@RequestParam("content") String content,@RequestParam("title") String title){
        ofmBlogService.saveBlog(content,title);
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessUrl(base);
        resultVO.setResultCode(resultVO.SUCCESSCODE);
        resultVO.setResultMessage("save blog success");
        return resultVO;
    }

}
