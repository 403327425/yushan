package com.gezi.hdlw.vo.sys;

import java.util.Date;
/**
 * 

* <p>Title: LwFactory</p>  

* <p>Description: 字典表</p>  

* @author lixinrong 

* @date 2019年3月28日
 */
public class LwDictionary {
    private Integer dkId;

    private String dictionaryTable;

    private String dictionaryColum;

    private String dictionaryValue;

    private Integer dictionarySerialNumber;

    private Integer dictionaryStatus;

    private String dictionaryRemarks;

    private Date dCreationTime;

    private Date dModificationTime;

    private Integer dOperator;
    
    //联表查询
    private String dictionaryTableName;//表名

    public Integer getDkId() {
        return dkId;
    }

    public void setDkId(Integer dkId) {
        this.dkId = dkId;
    }

    public String getDictionaryTable() {
        return dictionaryTable;
    }

    public void setDictionaryTable(String dictionaryTable) {
        this.dictionaryTable = dictionaryTable == null ? null : dictionaryTable.trim();
    }

    public String getDictionaryColum() {
        return dictionaryColum;
    }

    public void setDictionaryColum(String dictionaryColum) {
        this.dictionaryColum = dictionaryColum == null ? null : dictionaryColum.trim();
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue == null ? null : dictionaryValue.trim();
    }

    public Integer getDictionarySerialNumber() {
        return dictionarySerialNumber;
    }

    public void setDictionarySerialNumber(Integer dictionarySerialNumber) {
        this.dictionarySerialNumber = dictionarySerialNumber;
    }

    public Integer getDictionaryStatus() {
        return dictionaryStatus;
    }

    public void setDictionaryStatus(Integer dictionaryStatus) {
        this.dictionaryStatus = dictionaryStatus;
    }

    public String getDictionaryRemarks() {
        return dictionaryRemarks;
    }

    public void setDictionaryRemarks(String dictionaryRemarks) {
        this.dictionaryRemarks = dictionaryRemarks == null ? null : dictionaryRemarks.trim();
    }

    public Date getdCreationTime() {
        return dCreationTime;
    }

    public void setdCreationTime(Date dCreationTime) {
        this.dCreationTime = dCreationTime;
    }

    public Date getdModificationTime() {
        return dModificationTime;
    }

    public void setdModificationTime(Date dModificationTime) {
        this.dModificationTime = dModificationTime;
    }

    public Integer getdOperator() {
        return dOperator;
    }

    public void setdOperator(Integer dOperator) {
        this.dOperator = dOperator;
    }

	public String getDictionaryTableName() {
		return dictionaryTableName;
	}

	public void setDictionaryTableName(String dictionaryTableName) {
		this.dictionaryTableName = dictionaryTableName;
	}

	@Override
	public String toString() {
		return "LwDictionary [dkId=" + dkId + ", dictionaryTable="
				+ dictionaryTable + ", dictionaryColum=" + dictionaryColum
				+ ", dictionaryValue=" + dictionaryValue
				+ ", dictionarySerialNumber=" + dictionarySerialNumber
				+ ", dictionaryStatus=" + dictionaryStatus
				+ ", dictionaryRemarks=" + dictionaryRemarks
				+ ", dCreationTime=" + dCreationTime + ", dModificationTime="
				+ dModificationTime + ", dOperator=" + dOperator
				+ ", dictionaryTableName=" + dictionaryTableName + "]";
	}

}