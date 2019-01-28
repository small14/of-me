package com.sakura.ofm.service;


import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.tools.PageBean;

import java.util.List;

/**
 * @author y14
 * @date 2018-10-30
 * @describe Blog业务层
 */

public interface BlogService {


    /**
     * @describe 获取首页博客列表数据
     * @param pageNum 当前页数
     * @param pageCount 每页条数
     * @return
     */
    PageBean<Blog> getBolgForViewList(int pageNum, int pageCount);

    /**
     * @describe 获取改ID博客信息
     * @param id 博客ID
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * @describe 新增blog
     * @param content 内容
     * @param title  标题
     */
    int saveBlog(String content,String title);

    /**
     * 删除blog(逻辑删除)
     * @param blogId blogID
     * @return
     */
    int deleteBlog(Long blogId);

}
