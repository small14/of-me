package com.sakura.ofm.dao;

import com.sakura.ofm.entity.Author;
import com.sakura.ofm.entity.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorDao {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);
}