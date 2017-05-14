package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CustomerLoss;

/**
 * �ͻ���ʧDao�ӿ�
 * @author Administrator
 *
 */
public interface CustomerLossDao {

	/**
	 * ��ѯ�ͻ���ʧ����
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> findCustomerLoss(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ���ʧ��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCutomerLoss(Map<String,Object> map);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param id
	 * @return
	 */
	public CustomerLoss findById(Integer id);
	
	/**
	 * ��ӿͻ���ʧ��¼
	 * @param customerLoss
	 * @return
	 */
	public int addCustomerLoss(CustomerLoss customerLoss);
	
	/**
	 * �޸Ŀͻ���ʧ��¼
	 * @param customerLoss
	 * @return
	 */
	public int updateCustomerLoss(CustomerLoss customerLoss);
	
}
