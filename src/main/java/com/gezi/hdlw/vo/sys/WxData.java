package com.gezi.hdlw.vo.sys;

import java.util.Date;

public class WxData {
    private Integer id;

    private String openid;

    private String accessToken;

    private String jsapiTicket;

    private Date accessTokenTime;

    private Date jsapiTicketTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket == null ? null : jsapiTicket.trim();
    }

    public Date getAccessTokenTime() {
        return accessTokenTime;
    }

    public void setAccessTokenTime(Date accessTokenTime) {
        this.accessTokenTime = accessTokenTime;
    }

    public Date getJsapiTicketTime() {
        return jsapiTicketTime;
    }

    public void setJsapiTicketTime(Date jsapiTicketTime) {
        this.jsapiTicketTime = jsapiTicketTime;
    }
}