package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;

/**
 * ����service�ӿ�
 * @author Administrator
 *
 */
public interface OrderService {

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
	 * �����Ե�ɨ�趩���Ի�ȡ����Ԥ����Ϣ
	 */
	public void checkOrder();
	
//	/**
//	 * ���Ѿ������Ķ�����Ϣ���д���
//	 */
//	public void processOrderMessage(Integer id);
}
