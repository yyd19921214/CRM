package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Warehouse;


/**
 * 
 * @author yyd
 * �ֿ�ʵ��Dao�ӿ�
 *
 */
public interface WarehouseDao {
	/**
	 * ��ѯ�ֿ��¼
	 * @param map
	 * @return
	 */
	public List<Warehouse> findWarehouseByProperty(Map<String,Object> map);
	
	/**
	 * ��ѯ�ֿ��¼��¼��
	 * @return
	 */
	public Long getTotalWarehouse(Map<String,Object> map);
	
	/**
	 * ���Ӳֿ��¼
	 * @param warehouse
	 * @return
	 */
	public int addWarehouse(Warehouse warehouse);
	
	/**
	 * �޸Ĳֿ��¼
	 * @param warehouse
	 * @return
	 */
	public int updateWarehouse(Warehouse warehouse);
	
	/**
	 * ɾ���ֿ��¼
	 * @param id
	 * @return
	 */
	public int deleteWarehouse(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public Warehouse findById(Integer id);
	
	

}
