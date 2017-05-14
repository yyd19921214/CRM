package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Warehouse;


/**
 * 
 * @author yyd
 * 仓库记录Service接口
 *
 */
public interface WarehouseService {
	/**
	 * 查询仓库记录
	 * @param map
	 * @return
	 */
	public List<Warehouse> findWarehouseByProperty(Map<String,Object> map);
	
	/**
	 * 查询仓库记录记录数
	 * @param map
	 * @return
	 */
	public Long getTotalWarehouse(Map<String,Object> map);
	
	/**
	 * 添加仓库记录
	 * @param warehouse
	 * @return
	 */
	public int addWarehouse(Warehouse warehouse);
	
	/**
	 * 修改仓库记录
	 * @param warehouse
	 * @return
	 */
	public int updateWarehouse(Warehouse warehouse);
	
	/**
	 * 删除仓库记录
	 * @param id
	 * @return
	 */
	public int deleteWarehouse(Integer id);
	
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public Warehouse findById(Integer id);
}
