package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Recipt;
import com.java1234.entity.Resources;

public interface ResourcesDao {
	
	public List<Resources> queryAll();
	
	public List<Resources> queryResourcesByUser(String roleName);

}
