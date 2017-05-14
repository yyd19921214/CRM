package com.java1234.entity;

import java.io.Serializable;

import com.java1234.util.*;

/**
 * �û�ʵ��
 * @author Administrator
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 4654546423735192613L;

	private Integer id; // ���
	private String userName; // �û���
	private String password; // ����
	private String trueName; // ��ʵ����
	private String email; // �ʼ�
	private String phone; // �绰
	private String roleName; // ��ɫ���� ϵͳ����Ա �������� �ͻ����� �߹�
	@ExcelDataMapper(title="���",order=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ExcelDataMapper(title="�û���",order=2)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	@ExcelDataMapper(title="��������",order=3)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ExcelDataMapper(title="�绰",order=4)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@ExcelDataMapper(title="��ɫ����",order=5)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
