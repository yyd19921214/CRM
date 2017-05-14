package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

/**
 * ��ƷDao�ӿ�
 * @author Administrator
 *
 */
public interface ProductService {

	/**
	 * ���ݲ�Ʒ���Ʋ�ѯ��Ʒ
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
	 * ���ݲֿ��Ų��ҵ���Ӧ�Ĳ�Ʒ
	 * @param map
	 * @return
	 */
	public List<Product> findProductOfWarehouse(Map<String,Object> map);
	
	/**
	 * ���ݲ�Ʒid��ѯ��Ʒ
	 * @param map
	 * @return
	 */
	public Product findById(Integer id);
	

}
