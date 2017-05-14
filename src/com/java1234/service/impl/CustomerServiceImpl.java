package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.CustomerDao;
import com.java1234.dao.CustomerLossDao;
import com.java1234.dao.OrderDao;
import com.java1234.entity.Customer;
import com.java1234.entity.CustomerFw;
import com.java1234.entity.CustomerGc;
import com.java1234.entity.CustomerGx;
import com.java1234.entity.CustomerLoss;
import com.java1234.entity.Order;
import com.java1234.service.CustomerService;

/**
 * �ͻ�Serviceʵ����
 * @author Administrator
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerDao customerDao;
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	@Resource
	private OrderDao orderDao;
	
	@Override
	public List<Customer> findCustomer(Map<String, Object> map) {
		return customerDao.findCustomer(map);
	}

	@Override
	public Long getTotalCustomer(Map<String, Object> map) {
		return customerDao.getTotalCustomer(map);
	}

	@Override
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public int deleteCustomer(Integer id) {
		return customerDao.deleteCustomer(id);
	}

	@Override
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	@Override
	public void checkCustomerLoss() {
		List<Customer> customerList=customerDao.findLossCustomer(); // ������ʧ�ͻ�
		for(Customer c:customerList){
			CustomerLoss customerLoss=new CustomerLoss(); // ����ͻ���ʧʵ��
			customerLoss.setCusNo(c.getKhno()); // �ͻ����
			customerLoss.setCusName(c.getName()); // �ͻ�����
			customerLoss.setCusManager(c.getCusManager()); // �ͻ�����
			Order order=orderDao.findLastByCusId(c.getId()); // ����ָ���ͻ�����Ķ���
			customerLoss.setLastOrderTime(order.getOrderDate()); // ����������µ�ʱ��
			customerLossDao.addCustomerLoss(customerLoss); // ��ӵ��ͻ���ʧ��
		}
	}

	@Override
	public List<CustomerGx> findCutomerGx(Map<String, Object> map) {
		return customerDao.findCutomerGx(map);
	}

	@Override
	public Long getTotalCustomerGx(Map<String, Object> map) {
		return customerDao.getTotalCustomerGx(map);
	}

	@Override
	public List<CustomerGc> findCustomerGc() {
		return customerDao.findCustomerGc();
	}

	@Override
	public List<CustomerFw> findCustomerFw() {
		return customerDao.findCustomerFw();
	}

	@Override
	public List<Customer> findCustomerByArea(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerByArea(map);
	}
	
	

}
