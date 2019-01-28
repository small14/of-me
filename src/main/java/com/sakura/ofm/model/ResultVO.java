package com.sakura.ofm.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author y14
 * @date 2018-10-31
 * @decribe 后端处理结果VO
 */

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ResultVO {

    /**
     * 成功代码
     */
    public static final int SUCCESSCODE  = 4002;

    /**
     * 失败代码
     */
    public static final int FAILCODE = 4004;

    /**
     * 返回结果
     */
    private int resultCode;

    /**
     * 结果信息
     */
    private String resultMessage;

    /**
     *成功跳转地址
     */
    private String successUrl;

    /**
     *失败跳转地址
     */
    private String failUrl;


    /**
     * 返回对象
     */
    private Object resultObject;



    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }
}
