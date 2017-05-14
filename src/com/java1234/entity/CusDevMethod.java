package com.java1234.entity;



/**
 * 客户开发方法实体
 * @author Administrator
 *
 */
public class CusDevMethod {
	private Integer id; // 编号
	private String content; // 开发方法内容
	private Integer cost;   //方法成本
	private String createMan;//方法的创始者
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
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	
	
	

}
