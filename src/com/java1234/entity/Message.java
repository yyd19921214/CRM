package com.java1234.entity;

import java.util.Date;

public class Message {
	private Integer id;
	private String content;//��Ϣ������
	private Integer type;//��Ϣ���ͣ�0��������Ϣ��1���ͻ�������Ϣ��
	private Date createTime;//��Ϣ����ʱ��
	private Date procTime;//��Ϣ�Ĵ���ʱ��
	private Integer state;//��Ϣ״̬��0��δ���Ķ���1���Ѿ��Ķ���2:δ�Ķ����ǹ��ڣ�
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
