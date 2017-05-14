package com.java1234.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelDataMapper {

	public String title();   // ��������
		
	public int order();     // ����˳��
	
	public int width() default 16;   // ��Ԫ����

}
