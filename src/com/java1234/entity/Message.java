package com.java1234.entity;

import java.util.Date;

public class Message {
	private Integer id;
	private String content;//信息的内容
	private Integer type;//信息类型（0：订单消息，1：客户管理消息）
	private Date createTime;//信息产生时间
	private Date procTime;//信息的处理时间
	private Integer state;//信息状态（0：未被阅读，1：已经阅读，2:未阅读但是过期）
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getProcTime() {
		return procTime;
	}
	public void setProcTime(Date procTime) {
		this.procTime = procTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
