package com.gezi.GS.vo.sys;

import java.util.Date;

public class PerformList {
    private Long performId;

    private Long userId;

    private Integer taskId;

    private Date deadline;

    private String reservedFields;

    private Date createTime;

    private Integer finishNumber;

    private Integer state;

    public Long getPerformId() {
        return performId;
    }

    public void setPerformId(Long performId) {
        this.performId = performId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public Integer getFinishNumber() {
        return finishNumber;
    }

    public void setFinishNumber(Integer finishNumber) {
        this.finishNumber = finishNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}