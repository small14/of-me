package com.sakura.ofm.dao;

import com.sakura.ofm.entity.Blog;
import com.sakura.ofm.entity.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogDao {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);
}