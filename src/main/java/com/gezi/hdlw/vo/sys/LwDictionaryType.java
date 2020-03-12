package com.gezi.hdlw.vo.sys;

import java.util.Date;
/**
 * 

* <p>Title: LwFactory</p>  

* <p>Description: 字典类型表</p>  

* @author lixinrong 

* @date 2019年3月28日
 */
public class LwDictionaryType {
    private Integer dtkId;

    private String dictionaryTypeName;

    private String dictionaryTypeValue;

    private String dictionaryTypeType;

    private Integer dtParentId;

    private Date dtCreationTime;

    private Date dtModificationTime;

    private Integer dtOperator;
    
    //联表查询
    private String fatherName;//父表

    public Integer getDtkId() {
        return dtkId;
    }

    public void setDtkId(Integer dtkId) {
        this.dtkId = dtkId;
    }

    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName == null ? null : dictionaryTypeName.trim();
    }

    public String getDictionaryTypeValue() {
        return dictionaryTypeValue;
    }

    public void setDictionaryTypeValue(String dictionaryTypeValue) {
        this.dictionaryTypeValue = dictionaryTypeValue == null ? null : dictionaryTypeValue.trim();
    }

    public String getDictionaryTypeType() {
        return dictionaryTypeType;
    }

    public void setDictionaryTypeType(String dictionaryTypeType) {
        this.dictionaryTypeType = dictionaryTypeType == null ? null : dictionaryTypeType.trim();
    }

    public Integer getDtParentId() {
        return dtParentId;
    }

    public void setDtParentId(Integer dtParentId) {
        this.dtParentId = dtParentId;
    }

    public Date getDtCreationTime() {
        return dtCreationTime;
    }

    public void setDtCreationTime(Date dtCreationTime) {
        this.dtCreationTime = dtCreationTime;
    }

    public Date getDtModificationTime() {
        return dtModificationTime;
    }

    public void setDtModificationTime(Date dtModificationTime) {
        this.dtModificationTime = dtModificationTime;
    }

    public Integer getDtOperator() {
        return dtOperator;
    }

    public void setDtOperator(Integer dtOperator) {
        this.dtOperator = dtOperator;
    }

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@Override
	public String toString() {
		return "LwDictionaryType [dtkId=" + dtkId + ", dictionaryTypeName="
				+ dictionaryTypeName + ", dictionaryTypeValue="
				+ dictionaryTypeValue + ", dictionaryTypeType="
				+ dictionaryTypeType + ", dtParentId=" + dtParentId
				+ ", dtCreationTime=" + dtCreationTime
				+ ", dtModificationTime=" + dtModificationTime
				+ ", dtOperator=" + dtOperator + ", fatherName=" + fatherName
				+ "]";
	}
    
}