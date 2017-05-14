package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CusDevMethod;


public interface CusDevMethodService {
	
	public List<CusDevMethod> findCusDevMethod(Map<String,Object> map);
	
	public int addCusDevMethod(CusDevMethod cusDevMethod);
	
	public CusDevMethod findById(Integer id);
	
	public int updateCusDevMethod(CusDevMethod cusDevMethod);
	
	
	
	

}
