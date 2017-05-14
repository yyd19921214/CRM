package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

/**
 * ��ƷDao�ӿ�
 * @author Administrator
 *
 */
public interface ProductDao {

	/**
	 * ��ѯ��Ʒ
	 * @param map
	 * @return
	 */
	public List<Product> findProduct(Map<String,Object> map);
	
	/**
	 * ��ѯ��Ʒ��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalProduct(Map<String,Object> map);
	
	
	/**
	 * ͨ����Ʒid����ʵ��
	 * @param id
	 * @return
	 */
	public Product findById(Integer id);
	
	
	/**
	 * ���ݲֿ��Ų������洢�Ĳ�Ʒ
	 */
	public List<Product> findProductOfWarehouse(Map<String,Object> map);
	
}
