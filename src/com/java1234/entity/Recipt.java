package com.java1234.entity;

import java.util.Date;

/**
 * 
 * @author yyd
 * �ֿ�䶯����ʵ��
 *
 */
public class Recipt {
	private Integer id; // ���
	private Warehouse warehouse; // ���ݶ�Ӧ�Ĳֿ�
	private Product product; // ���ݶ�Ӧ�Ļ���
	private Integer changeType; // ���ݶ�Ӧ�ı䶯���� 0������  1�����
	private String person; // ������
	private Date changeTime; //�䶯ʱ��
	private Integer count;       //�䶯����
	private String remark;   //��ע�ֶ�
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getChangeType() {
		return changeType;
	}
	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
