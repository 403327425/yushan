package com.gezi.hdlw.vo.sys;

import java.util.Date;

public class StudyData {
    private Integer id;

    private String sdType;

    private String sdName;

    private Date startTime;

    private String sdPicture;

    private String sdHyperlinks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdType() {
        return sdType;
    }

    public void setSdType(String sdType) {
        this.sdType = sdType == null ? null : sdType.trim();
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSdPicture() {
        return sdPicture;
    }

    public void setSdPicture(String sdPicture) {
        this.sdPicture = sdPicture == null ? null : sdPicture.trim();
    }

    public String getSdHyperlinks() {
        return sdHyperlinks;
    }

    public void setSdHyperlinks(String sdHyperlinks) {
        this.sdHyperlinks = sdHyperlinks == null ? null : sdHyperlinks.trim();
    }
}