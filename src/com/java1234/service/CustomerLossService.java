package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CustomerLoss;

/**
 * �ͻ���ʧService�ӿ�
 * @author Administrator
 *
 */
public interface CustomerLossService {

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
	 * �޸Ŀͻ���ʧ��¼
	 * @param customerLoss
	 * @return
	 */
	public int updateCustomerLoss(CustomerLoss customerLoss);
}
