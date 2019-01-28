package com.sakura.ofm.model;

import com.sakura.ofm.entity.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author y14
 * @date 2019-01-22
 * 默认前端返回数据
 */
public class DefaultResponseModel {

    private String baseUrl;

    private boolean login;


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
