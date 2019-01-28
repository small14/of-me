package com.sakura.ofm.service;

import com.sakura.ofm.entity.Author;

import java.util.List;

public interface UserAuthorService{

    List<Author> queryUserAuthor(String userId);
}
