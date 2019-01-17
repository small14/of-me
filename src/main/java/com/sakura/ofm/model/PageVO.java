package com.sakura.ofm.model;

/**
 * @author y14
 * @date 2018-10-30
 * @decribe 页数信息VO
 */
public class PageVO {

    /**
     * 总页数
     */
    private int maxPageNum;

    /**
     * 当前页数
     */
    private int nowPageNum;

    public int getMaxPageNum() {
        return maxPageNum;
    }

    public void setMaxPageNum(int maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

    public int getNowPageNum() {
        return nowPageNum;
    }

    public void setNowPageNum(int nowPageNum) {
        this.nowPageNum = nowPageNum;
    }
}
