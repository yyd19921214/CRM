package com.java1234.entity;

import java.util.Date;

/**
 * �ͻ������ƻ�ʵ��
 * @author Administrator
 *
 */
public class CusDevPlan {

	private Integer id; // ���
	private SaleChance saleChance; // ���ۻ���
	private String planItem; // �ƻ���
	private Date planDate; // �ƻ�����
	private String exeAffect; // ִ��Ч��
	private CusDevMethod cusDevMethod;//ʹ�ñ�׼��������ʽ
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SaleChance getSaleChance() {
		return saleChance;
	}
	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}
	public String getPlanItem() {
		return planItem;
	}
	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getExeAffect() {
		return exeAffect;
	}
	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}
	public CusDevMethod getCusDevMethod() {
		return cusDevMethod;
	}
	public void setCusDevMethod(CusDevMethod cusDevMethod) {
		this.cusDevMethod = cusDevMethod;
	}
	
	
	
}
