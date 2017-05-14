package com.java1234.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelDataMapper {

	public String title();   // 标题名称
		
	public int order();     // 标题顺序
	
	public int width() default 16;   // 单元格宽度

}
