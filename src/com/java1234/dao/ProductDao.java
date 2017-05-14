package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

/**
 * 产品Dao接口
 * @author Administrator
 *
 */
public interface ProductDao {

	/**
	 * 查询产品
	 * @param map
	 * @return
	 */
	public List<Product> findProduct(Map<String,Object> map);
	
	/**
	 * 查询产品记录数
	 * @param map
	 * @return
	 */
	public Long getTotalProduct(Map<String,Object> map);
	
	
	/**
	 * 通过产品id查找实体
	 * @param id
	 * @return
	 */
	public Product findById(Integer id);
	
	
	/**
	 * 根据仓库编号查找所存储的产品
	 */
	public List<Product> findProductOfWarehouse(Map<String,Object> map);
	
}
