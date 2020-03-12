package com.gezi.hdlw.vo.sys;

/**
 * @dece 序号
 * @author Administrator
 *
 */
public class LwSeqence {
 	
	private Integer seqType;		//序号类型
	private String description;		//解释
	private Long crtValue;			//序号索引
	private Long len;				//长度
	private String prefix;			//前缀
	private String bgcont;			//开头

	public Integer getSeqType() {
		return seqType;
	}

	public void setSeqType(Integer seqType) {
		this.seqType = seqType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCrtValue() {
		return crtValue;
	}

	public void setCrtValue(Long crtValue) {
		this.crtValue = crtValue;
	}

	public Long getLen() {
		return len;
	}

	public void setLen(Long len) {
		this.len = len;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getBgcont() {
		return bgcont;
	}

	public void setBgcont(String bgcont) {
		this.bgcont = bgcont;
	}

	@Override
	public String toString() {
		return "SequenceVO [seqType=" + seqType + ", description=" + description + ", crtValue=" + crtValue + ", len=" + len + ", prefix="
				+ prefix + ", bgcont=" + bgcont + "]";
	}
}
