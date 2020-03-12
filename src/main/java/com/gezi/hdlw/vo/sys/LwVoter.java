package com.gezi.hdlw.vo.sys;

import java.util.Date;

public class LwVoter {
    private Long id;

    private Long candidateId;

    private Long activityId;

    private String ip;

    private Date voteTime;

    private Long userId;

    private Integer nowState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNowState() {
        return nowState;
    }

    public void setNowState(Integer nowState) {
        this.nowState = nowState;
    }
}