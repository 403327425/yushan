package com.gezi.hdlw.search.sys;

public class LwQuestionnaireSearch {
	
	private Integer qnId;
	private String qnProblem;
	private String qnAnswer;
	private Integer qnType;
	
	private Integer page;      //页码
   	private Integer limit;     //页条数
   	private String beginDate;     //开始时间
   	private String endDate;     //结束时间
   	
   	
   	public Integer getQnId() {
		return qnId;
	}
	public void setQnId(Integer qnId) {
		this.qnId = qnId;
	}
	public String getQnProblem() {
		return qnProblem;
	}
	public void setQnProblem(String qnProblem) {
		this.qnProblem = qnProblem;
	}
	public String getQnAnswer() {
		return qnAnswer;
	}
	public void setQnAnswer(String qnAnswer) {
		this.qnAnswer = qnAnswer;
	}
	public Integer getQnType() {
		return qnType;
	}
	public void setQnType(Integer qnType) {
		this.qnType = qnType;
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
		return "LwQuestionnaireSearch [qnId=" + qnId + ", qnProblem=" + qnProblem + ", qnAnswer=" + qnAnswer
				+ ", qnType=" + qnType + ", page=" + page + ", limit=" + limit + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + "]";
	}
}
