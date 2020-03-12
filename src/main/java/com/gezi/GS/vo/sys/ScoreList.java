package com.gezi.GS.vo.sys;

import java.util.Date;

public class ScoreList {
    private Long id;

    private Long userId;

    private Long score;

    private String scoreDetail;

    private Integer taskid;

    private Date createTime;

    private String reservedFields;

    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getScoreDetail() {
        return scoreDetail;
    }

    public void setScoreDetail(String scoreDetail) {
        this.scoreDetail = scoreDetail == null ? null : scoreDetail.trim();
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReservedFields() {
        return reservedFields;
    }

    public void setReservedFields(String reservedFields) {
        this.reservedFields = reservedFields == null ? null : reservedFields.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}