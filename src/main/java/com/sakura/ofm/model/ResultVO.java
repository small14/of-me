package com.sakura.ofm.model;
/**
 * @author y14
 * @date 2018-10-31
 * @decribe 后端处理结果VO
 */
public class ResultVO {

    /**
     * 成功代码
     */
    public final String SUCCESSCODE  = "success";

    /**
     * 失败代码
     */
    public final String FAILCODE = "fail";

    /**
     * 返回结果
     */
    private String resultCode;

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


    public String getSUCCESSCODE() {
        return SUCCESSCODE;
    }

    public String getFAILCODE() {
        return FAILCODE;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
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
}
