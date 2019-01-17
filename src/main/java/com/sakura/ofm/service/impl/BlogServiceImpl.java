package com.sakura.ofm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sakura.ofm.dao.BlogDao;
import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.entity.BlogExample;
import com.sakura.ofm.service.BlogService;
import com.sakura.ofm.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author y14
 * @date 2018-10-30
 * @describe ofmBlog业务层
 */
@Service("ofmBlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;




    @Override
    public PageBean getBolgForViewList(int pageNum, int pageCount) {

        PageHelper.startPage(pageNum,pageCount);
        BlogExample example = new BlogExample();
        example.setDistinct(false);
        example.setOrderByClause("`create_time` DESC");
        List<Blog> blogList = blogDao.selectByExampleWithBLOBs(example);
        int countNums = (int)blogDao.countByExample(example);
        PageBean pageData = new PageBean<Blog>(pageNum, pageCount, countNums);
        pageData.setItems(blogList);
        return pageData;
    }

    @Override
    public Blog getBlogById(Long id) {
        BlogExample example = new BlogExample();
        example.setDistinct(false);
        BlogExample.Criteria criteria =  example.createCriteria();
        criteria.andBlogIdEqualTo(id);
        return blogDao.selectByExampleWithBLOBs(example).get(0);
    }


    @Override
    public int saveBlog(String content, String title) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setCreateTime(new Date());
        blog.setHeadImg("ddd");
        blog.setContent(content);
        blog.setPackageId(1);
        blog.setReadCount(0l);
        blog.setStatus(0);
        return blogDao.insertSelective(blog);
    }


}
