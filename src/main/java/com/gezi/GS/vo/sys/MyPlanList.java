package com.gezi.GS.vo.sys;

import java.util.Date;

public class MyPlanList {
    private Integer myPlanId;

    private Integer taskTypeId;

    private String openid;

    private String reservedFields;

    private Date createTime;

    private Integer state;

    public Integer getMyPlanId() {
        return myPlanId;
    }

    public void setMyPlanId(Integer myPlanId) {
        this.myPlanId = myPlanId;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
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