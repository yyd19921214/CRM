package com.java1234.service;

import java.util.List;
import java.util.Map;
import com.java1234.entity.CustomerService;

/**
 * �ͻ�����Service�ӿ�
 * @author Administrator
 *
 */
public interface CustomerServiceService {

	/**
	 * ��ѯ�ͻ�����
	 * @param map
	 * @return
	 */
	public List<CustomerService> findCustomerService(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ������¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerService(Map<String,Object> map);
	
	/**
	 * ��ӿͻ�����
	 * @param customerService
	 * @return
	 */
	public int addCustomerService(CustomerService customerService);
	
	/**
	 * �޸Ŀͻ�����
	 * @param customerService
	 * @return
	 */
	public int updateCustomerService(CustomerService customerService);
	
	/**
	 * ɾ���ͻ�����
	 * @param id
	 * @return
	 */
	public int deleteCustomerService(Integer id);
	
	/**
	 * ͨ��ID����ʵ��
	 * @param id
	 * @return
	 */
	public CustomerService findById(Integer id);
	
	
}
