package com.java1234.util;

/**
 * �����洢Excel����Ķ���ͨ���ö�����Ի�ȡ����ͷ����Ķ�Ӧ��ϵ
 */
public class ExcelHeader implements Comparable<ExcelHeader> {

	private String title; // ��������
	private int order; // ����˳��
	private int width; // ���
	private String methodName; // ��Ӧ��������

	
	
	public ExcelHeader(String title, int order, int width, String methodName) {
		super();
		this.width = width;
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}

	public int compareTo(ExcelHeader o) {
		return order > o.order ? 1 : (order < o.order? -1 : 0);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
