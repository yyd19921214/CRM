package com.java1234.entity;

import java.io.Serializable;

import com.java1234.util.*;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 4654546423735192613L;

	private Integer id; // 编号
	private String userName; // 用户名
	private String password; // 密码
	private String trueName; // 真实姓名
	private String email; // 邮件
	private String phone; // 电话
	private String roleName; // 角色名称 系统管理员 销售主管 客户经理 高管
	@ExcelDataMapper(title="编号",order=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ExcelDataMapper(title="用户名",order=2)
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
	@ExcelDataMapper(title="电子邮箱",order=3)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ExcelDataMapper(title="电话",order=4)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@ExcelDataMapper(title="角色名称",order=5)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
