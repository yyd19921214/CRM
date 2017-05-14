package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.OrderDetails;

/**
 * ������ϸDao�ӿ�
 * @author Administrator
 *
 */
public interface OrderDetailsDao {

	/**
	 * ��ѯ������ϸ
	 * @param map
	 * @return
	 */
	public List<OrderDetails> findOrderDetails(Map<String,Object> map);
	
	/**
	 * ��ѯ������ϸ��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalOrderDetails(Map<String,Object> map);
	
	/**
	 * ��ȡָ��������
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(int orderId);
}
