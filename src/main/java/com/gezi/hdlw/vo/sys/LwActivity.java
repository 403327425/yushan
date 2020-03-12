package com.gezi.hdlw.vo.sys;

import java.util.Date;

public class LwActivity {
    private Long activityId;

    private String activityName;

    private String activityDescribe;

    private Date startTime;

    private Date endTime;

    private Date startTime2;

    private Date endTime2;

    private Long visitCount;

    private String picture;

    private Integer sortMode;

    private Integer voteMode;

    private Integer limitMode;

    private Integer resultMode;

    private Integer showMode;

    private Integer limitNumber;

    private String qrCode;

    private Integer voteMode2;

    private Integer candidateCount;

    private Integer nowState;

    private String prefix;

    private String openid;

    private String schoolName;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityDescribe() {
        return activityDescribe;
    }

    public void setActivityDescribe(String activityDescribe) {
        this.activityDescribe = activityDescribe == null ? null : activityDescribe.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(Date startTime2) {
        this.startTime2 = startTime2;
    }

    public Date getEndTime2() {
        return endTime2;
    }

    public void setEndTime2(Date endTime2) {
        this.endTime2 = endTime2;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getSortMode() {
        return sortMode;
    }

    public void setSortMode(Integer sortMode) {
        this.sortMode = sortMode;
    }

    public Integer getVoteMode() {
        return voteMode;
    }

    public void setVoteMode(Integer voteMode) {
        this.voteMode = voteMode;
    }

    public Integer getLimitMode() {
        return limitMode;
    }

    public void setLimitMode(Integer limitMode) {
        this.limitMode = limitMode;
    }

    public Integer getResultMode() {
        return resultMode;
    }

    public void setResultMode(Integer resultMode) {
        this.resultMode = resultMode;
    }

    public Integer getShowMode() {
        return showMode;
    }

    public void setShowMode(Integer showMode) {
        this.showMode = showMode;
    }

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public Integer getVoteMode2() {
        return voteMode2;
    }

    public void setVoteMode2(Integer voteMode2) {
        this.voteMode2 = voteMode2;
    }

    public Integer getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(Integer candidateCount) {
        this.candidateCount = candidateCount;
    }

    public Integer getNowState() {
        return nowState;
    }

    public void setNowState(Integer nowState) {
        this.nowState = nowState;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }
}