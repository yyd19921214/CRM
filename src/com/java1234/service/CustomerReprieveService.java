package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CustomerReprieve;

/**
 * �ͻ���ʧ�ݻ���ʩService�ӿ�
 * @author Administrator
 *
 */
public interface CustomerReprieveService {

	/**
	 * ��ѯ�ͻ���ʧ�ݻ���ʩ����
	 * @param map
	 * @return
	 */
	public List<CustomerReprieve> findCustomerReprieve(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ���ʧ�ݻ���ʩ��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerReprieve(Map<String,Object> map);
	
	/**
	 * ��ӿͻ���ʧ�ݻ���ʩ
	 * @param customerReprieve
	 * @return
	 */
	public int addCustomerReprieve(CustomerReprieve customerReprieve);
	
	/**
	 * �޸Ŀͻ���ʧ�ݻ���ʩ
	 * @param customerReprieve
	 * @return
	 */
	public int updateCustomerReprieve(CustomerReprieve customerReprieve);
	
	/**
	 * ɾ���ͻ���ʧ�ݻ���ʩ
	 * @param id
	 * @return
	 */
	public int deleteCustomerReprieve(Integer id);
}
