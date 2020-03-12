package com.gezi.hdlw.vo.sys;

public class LwCandidate {
    private Long candidateId;

    private String candidateName;

    private String iphone;

    private String address;

    private String candidateDescribe;

    private String picture;

    private Long activityId;

    private String openid;

    private String selectId;

    private Integer nowState;

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName == null ? null : candidateName.trim();
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone == null ? null : iphone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCandidateDescribe() {
        return candidateDescribe;
    }

    public void setCandidateDescribe(String candidateDescribe) {
        this.candidateDescribe = candidateDescribe == null ? null : candidateDescribe.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId == null ? null : selectId.trim();
    }

    public Integer getNowState() {
        return nowState;
    }

    public void setNowState(Integer nowState) {
        this.nowState = nowState;
    }
}