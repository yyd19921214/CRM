package com.java1234.quartz;

import com.java1234.service.CustomerService;

/**
 * ������ʧ�ͻ���ʱ����
 * @author Administrator
 *
 */
public class FindLossCustomerJob {

	private CustomerService customerService; // �ͻ�Service
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void work() {  
		customerService.checkCustomerLoss();
    }  
}
