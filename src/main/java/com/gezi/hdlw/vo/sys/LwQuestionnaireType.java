package com.gezi.hdlw.vo.sys;

public class LwQuestionnaireType {
    private Integer typeId;

    private String typeName;

    private String typeMark;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeMark() {
        return typeMark;
    }

    public void setTypeMark(String typeMark) {
        this.typeMark = typeMark == null ? null : typeMark.trim();
    }
}