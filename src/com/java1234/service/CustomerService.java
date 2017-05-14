package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Customer;
import com.java1234.entity.CustomerFw;
import com.java1234.entity.CustomerGc;
import com.java1234.entity.CustomerGx;

/**
 * �ͻ�Service�ӿ�
 * @author Administrator
 *
 */
public interface CustomerService {

	/**
	 * ��ѯ�ͻ�
	 * @param map
	 * @return
	 */
	public List<Customer> findCustomer(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ���¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCustomer(Map<String,Object> map);
	
	/**
	 * ��ӿͻ�
	 * @param customer
	 * @return
	 */
	public int addCustomer(Customer customer);
	
	/**
	 * �޸Ŀͻ�
	 * @param customer
	 * @return
	 */
	public int updateCustomer(Customer customer);
	
	/**
	 * ɾ���ͻ�
	 * @param id
	 * @return
	 */
	public int deleteCustomer(Integer id);
	
	/**
	 * ͨ��Id����ʵ��
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
	
	/**
	 * ������ʧ�ͻ���������ӵ���ʧ�ͻ�����
	 */
	public void checkCustomerLoss();
	
	/**
	 * ��ѯ�ͻ�����
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCutomerGx(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ����׼�¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ�����
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * ��ѯ�ͻ��������
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
	
	
	/**
	 * ���ݵ��������û�
	 * @return
	 */
	public List<Customer> findCustomerByArea(Map<String,Object> map);
}
