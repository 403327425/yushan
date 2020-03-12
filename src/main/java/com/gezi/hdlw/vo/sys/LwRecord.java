package com.gezi.hdlw.vo.sys;

public class LwRecord {
    private Integer id;

    private Integer userId;

    private Integer typeId;

    private String recordAnswer;

    private Double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getRecordAnswer() {
        return recordAnswer;
    }

    public void setRecordAnswer(String recordAnswer) {
        this.recordAnswer = recordAnswer == null ? null : recordAnswer.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}