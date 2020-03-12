package com.gezi.hdlw.vo.common;

import java.util.Date;

public class LwEmployee {
    private Integer ekId;

    private Integer post;

    private String employeeName;

    private Integer sex;

    private String eContactWay;

    private Integer eStatus;

    private Date eCreationTime;

    private Date eModificationTime;

    private Integer eOperator;
    
    //联表查询
    private String againPost;//职位
    private String againSex;//性别
    private String againOperator;//操作人

    public Integer getEkId() {
        return ekId;
    }

    public void setEkId(Integer ekId) {
        this.ekId = ekId;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String geteContactWay() {
        return eContactWay;
    }

    public void seteContactWay(String eContactWay) {
        this.eContactWay = eContactWay == null ? null : eContactWay.trim();
    }

    public Integer geteStatus() {
        return eStatus;
    }

    public void seteStatus(Integer eStatus) {
        this.eStatus = eStatus;
    }

    public Date geteCreationTime() {
        return eCreationTime;
    }

    public void seteCreationTime(Date eCreationTime) {
        this.eCreationTime = eCreationTime;
    }

    public Date geteModificationTime() {
        return eModificationTime;
    }

    public void seteModificationTime(Date eModificationTime) {
        this.eModificationTime = eModificationTime;
    }

    public Integer geteOperator() {
        return eOperator;
    }

    public void seteOperator(Integer eOperator) {
        this.eOperator = eOperator;
    }

	public String getAgainPost() {
		return againPost;
	}

	public void setAgainPost(String againPost) {
		this.againPost = againPost;
	}

	public String getAgainSex() {
		return againSex;
	}

	public void setAgainSex(String againSex) {
		this.againSex = againSex;
	}

	public String getAgainOperator() {
		return againOperator;
	}

	public void setAgainOperator(String againOperator) {
		this.againOperator = againOperator;
	}

	@Override
	public String toString() {
		return "LwEmployee [ekId=" + ekId + ", post=" + post
				+ ", employeeName=" + employeeName + ", sex=" + sex
				+ ", eContactWay=" + eContactWay + ", eStatus=" + eStatus
				+ ", eCreationTime=" + eCreationTime + ", eModificationTime="
				+ eModificationTime + ", eOperator=" + eOperator
				+ ", againPost=" + againPost + ", againSex=" + againSex
				+ ", againOperator=" + againOperator + "]";
	}

}