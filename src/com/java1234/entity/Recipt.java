package com.java1234.entity;

import java.util.Date;

/**
 * 
 * @author yyd
 * 仓库变动单据实体
 *
 */
public class Recipt {
	private Integer id; // 编号
	private Warehouse warehouse; // 单据对应的仓库
	private Product product; // 单据对应的货物
	private Integer changeType; // 单据对应的变动类型 0：出库  1：入库
	private String person; // 经手人
	private Date changeTime; //变动时间
	private Integer count;       //变动数量
	private String remark;   //备注字段
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
