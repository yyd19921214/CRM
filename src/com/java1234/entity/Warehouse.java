package com.java1234.entity;

import java.util.Date;


/**
 * @author yyd
 * �ֿ�ʵ��
 */
public class Warehouse {
	private Integer id;       // ���
	private String  warehouseName;     //�ֿ�����
	private String  location; //�ֿ��������
	private String  manager;  //�ֿ����Ա����
	private Date lastChangeTime; // ���䶯ʱ��
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(Date lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
