package com.gezi.hdlw.search.common;

import java.util.Date;

/**
 * 
 * @version:1.0
 * @Description:员工条件类
 * @author:李云飞
 * @date: 2019年4月3日上午10:10:03
 */
public class LwEmployeeSearch {
    private Integer ekId;

    private Integer post;

    private String employeeName;

    private Integer sex;

    private String eContactWay;

    private Integer eStatus;

    private Date eCreationTime;

    private Date eModificationTime;

    private Integer eOperator;
    
    private Integer page;      //页码
	private Integer limit;     //页条数
	private String beginDate;     //开始时间
	private String endDate;     //结束时间
	
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
		this.employeeName = employeeName;
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
		this.eContactWay = eContactWay;
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "LwEmployee [ekId=" + ekId + ", post=" + post
				+ ", employeeName=" + employeeName + ", sex=" + sex
				+ ", eContactWay=" + eContactWay + ", eStatus=" + eStatus
				+ ", eCreationTime=" + eCreationTime + ", eModificationTime="
				+ eModificationTime + ", eOperator=" + eOperator + ", page="
				+ page + ", limit=" + limit + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}

}