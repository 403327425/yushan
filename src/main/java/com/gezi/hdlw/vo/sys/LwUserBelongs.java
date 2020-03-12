package com.gezi.hdlw.vo.sys;

import java.util.Date;

public class LwUserBelongs {
	private Integer ubkId;

	private Integer akId;

	private String fkId;

	private String skId;

	private Date ubCreationTime;

	private Date ubModificationTime;

	private Integer ubOperator;

	public Integer getUbkId() {
		return ubkId;
	}

	public void setUbkId(Integer ubkId) {
		this.ubkId = ubkId;
	}

	public Integer getAkId() {
		return akId;
	}

	public void setAkId(Integer akId) {
		this.akId = akId;
	}

	public String getFkId() {
		return fkId;
	}

	public void setFkId(String fkId) {
		this.fkId = (fkId == null || fkId.trim() == "") ? null : fkId.trim();
	}

	public String getSkId() {
		return skId;
	}

	public void setSkId(String skId) {
		this.skId = skId == null ? null : skId.trim();
	}

	public Date getUbCreationTime() {
		return ubCreationTime;
	}

	public void setUbCreationTime(Date ubCreationTime) {
		this.ubCreationTime = ubCreationTime;
	}

	public Date getUbModificationTime() {
		return ubModificationTime;
	}

	public void setUbModificationTime(Date ubModificationTime) {
		this.ubModificationTime = ubModificationTime;
	}

	public Integer getUbOperator() {
		return ubOperator;
	}

	public void setUbOperator(Integer ubOperator) {
		this.ubOperator = ubOperator;
	}

	@Override
	public String toString() {
		return "LwUserBelongs [fkId=" + fkId + ", skId=" + skId + "]";
	}

}