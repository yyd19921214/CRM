package com.java1234.entity;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class Resources implements java.io.Serializable {

	private Integer id;
	private String name;
	private Integer parentId; //����Id
	private String resKey;//���Ȩ��KEY��Ψһ�ģ�����ʱҪע�⣬
	private String resUrl;//URL��ַ�����磺/videoType/query��������Ҫ��Ŀ����http://xxx:8080
	private Integer level;//���� �˵���˳��
	private String type;//���ͣ�Ŀ¼���˵�  ��Ť������spring security3��ȫȨ���У��漰��ȷ����Ť����
	private String description;
	private List<Resources> children = new ArrayList<Resources>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public List<Resources> getChildren() {
		return children;
	}

	public void setChildren(List<Resources> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", parentId=" + parentId + ", resKey=" + resKey + ", resUrl=" + resUrl + ", level=" + level + ", type=" + type + ", description=" + description + ", children=" + children + "]";
	}

}
