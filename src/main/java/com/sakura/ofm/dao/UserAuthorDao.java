package com.sakura.ofm.dao;

import com.sakura.ofm.entity.Author;
import com.sakura.ofm.entity.UserAuthor;
import com.sakura.ofm.entity.UserAuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthorDao {
    long countByExample(UserAuthorExample example);

    int deleteByExample(UserAuthorExample example);

    int insert(UserAuthor record);

    int insertSelective(UserAuthor record);

    List<UserAuthor> selectByExample(UserAuthorExample example);

    int updateByExampleSelective(@Param("record") UserAuthor record, @Param("example") UserAuthorExample example);

    int updateByExample(@Param("record") UserAuthor record, @Param("example") UserAuthorExample example);

    /**
     * 获取用户权限
     * @param userId 用户ID
     * @return
     */
    List<Author> queryUserAuthor(String userId);
}