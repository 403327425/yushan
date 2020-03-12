package com.gezi.GS.vo.sys;

import java.util.Date;

public class MedalList {
    private Integer madelId;

    private String madelName;

    private String madelText;

    private Integer taskNumber;

    private Integer score;

    private String reservedFields;

    private Date createTime;

    private Integer state;

    public Integer getMadelId() {
        return madelId;
    }

    public void setMadelId(Integer madelId) {
        this.madelId = madelId;
    }

    public String getMadelName() {
        return madelName;
    }

    public void setMadelName(String madelName) {
        this.madelName = madelName == null ? null : madelName.trim();
    }

    public String getMadelText() {
        return madelText;
    }

    public void setMadelText(String madelText) {
        this.madelText = madelText == null ? null : madelText.trim();
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReservedFields() {
        return reservedFields;
    }

    public void setReservedFields(String reservedFields) {
        this.reservedFields = reservedFields == null ? null : reservedFields.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}