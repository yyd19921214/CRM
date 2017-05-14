package com.java1234.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;

/**
 * ����Dao�ӿ�
 * @author Administrator
 *
 */
public interface OrderDao {

	/**
	 * ��ѯ����
	 * @param map
	 * @return
	 */
	public List<Order> findOrder(Map<String,Object> map);
	
	/**
	 * ��ѯ������¼��
	 * @param map
	 * @return
	 */
	public Long getTotalOrder(Map<String,Object> map);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);
	
	/**
	 * ����ָ���ͻ�������Ķ���
	 * @param cusId
	 * @return
	 */
	public Order findLastByCusId(int cusId);
}
