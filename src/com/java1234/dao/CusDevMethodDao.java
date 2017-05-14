package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CusDevMethod;


public interface CusDevMethodDao {
public List<CusDevMethod> findCusDevMethod(Map<String,Object> map);
	
	/**
	 * 查询客户开发方法记录数
	 * @param map
	 * @return
	 */
	public Long getTotalCusDevMethod(Map<String,Object> map);
	
	/**
	 * 添加客户开发方法
	 * @param cusDevPlan
	 * @return
	 */
	public int addCusDevMethod(CusDevMethod cusDevMethod);
	
	/**
	 * 修改客户开发方法
	 * @param cusDevPlan
	 * @return
	 */
	public int updateCusDevMethod(CusDevMethod cusDevMethod);
	
	/**
	 * 删除客户开发方法
	 * @param id
	 * @return
	 */
	public int deleteCusDevMethod(Integer id);
	
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public CusDevMethod findById(Integer id);

}
