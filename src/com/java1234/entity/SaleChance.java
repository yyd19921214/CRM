package com.java1234.entity;

import java.util.Date;

import com.java1234.util.ExcelDataMapper;


/**
 * ���ۻ���ʵ��
 * @author Administrator
 *
 */
public class SaleChance {

	private Integer id; // ���
	private String chanceSource; // ������Դ
	private String customerName; // �ͻ�����
	private int cgjl; // �ɹ�����
	private String overView; // ��Ҫ
	private String linkMan; // ��ϵ��
	private String linkPhone; // ��ϵ�绰
	private String description; // ��������
	private String createMan; // ������ 
	private Date createTime; // ����ʱ��
	private User assignMan; // ָ����
	private Date assignTime; // ָ��ʱ��
	
	private Integer state; // ����״̬ 0 δ���� 1 �ѷ���
	private Integer devResult; // �ͻ�����״̬ 0 δ���� 1 ������ 2 �����ɹ� 3 ����ʧ��
	@ExcelDataMapper(title="���",order=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getChanceSource() {
		return chanceSource;
	}
	public void setChanceSource(String chanceSource) {
		this.chanceSource = chanceSource;
	}
	@ExcelDataMapper(title="�ͻ�����",order=2)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCgjl() {
		return cgjl;
	}
	public void setCgjl(int cgjl) {
		this.cgjl = cgjl;
	}
	@ExcelDataMapper(title="��Ҫ",order=3)
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	@ExcelDataMapper(title="��ϵ��",order=4)
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	@ExcelDataMapper(title="��ϵ�绰",order=5)
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ExcelDataMapper(title="������",order=6)
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	@ExcelDataMapper(title="����ʱ��",order=7)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getAssignMan() {
		return assignMan;
	}
	public void setAssignMan(User assignMan) {
		this.assignMan = assignMan;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	@ExcelDataMapper(title="״̬",order=8)
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDevResult() {
		return devResult;
	}
	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}
	
	
}
