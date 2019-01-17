package com.sakura.ofm.model;


import com.sakura.ofm.entity.Blog;

import java.util.List;

/**
 * @author y14
 * @date 2018-10-30
 * @decribe 首页blog列表vo
 */
public class BlogListVO {

    /**
     * 博客所属分类ID
     */
    private Integer packageId;

    /**
     * 博客列表
     */
    private List<Blog> blogList;


    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
