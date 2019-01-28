package com.sakura.ofm.service.impl;

import com.sakura.ofm.dao.AuthorDao;
import com.sakura.ofm.dao.UserAuthorDao;
import com.sakura.ofm.entity.Author;
import com.sakura.ofm.service.UserAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userAuthorService")
public class UserAuthorServiceImpl implements UserAuthorService {

    @Autowired
    private UserAuthorDao userAuthorDao;


    @Override
    public List<Author> queryUserAuthor(String userId) {

        return userAuthorDao.queryUserAuthor(userId);
    }
}
