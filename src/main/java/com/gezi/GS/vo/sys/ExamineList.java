package com.gezi.GS.vo.sys;

import java.util.Date;

public class ExamineList {
    private Integer examineId;

    private String examineText;

    private String examineUrl;

    private String reservedFields;

    private Date createTime;

    private Integer state;

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public String getExamineText() {
        return examineText;
    }

    public void setExamineText(String examineText) {
        this.examineText = examineText == null ? null : examineText.trim();
    }

    public String getExamineUrl() {
        return examineUrl;
    }

    public void setExamineUrl(String examineUrl) {
        this.examineUrl = examineUrl == null ? null : examineUrl.trim();
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