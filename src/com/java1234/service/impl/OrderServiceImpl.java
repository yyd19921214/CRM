package com.java1234.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.MessageDao;
import com.java1234.dao.OrderDao;
import com.java1234.entity.Message;
import com.java1234.entity.Order;
import com.java1234.service.OrderService;

/**
 * ����Serviceʵ����
 * @author Administrator
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDao orderDao;
	@Resource
	private MessageDao messageDao;
	
	@Override
	public List<Order> findOrder(Map<String, Object> map) {
		return orderDao.findOrder(map);
	}

	@Override
	public Long getTotalOrder(Map<String, Object> map) {
		return orderDao.getTotalOrder(map);
	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

	@Override
	public void checkOrder() {
		System.out.println("----------��ʱ����������-------");
		//���3��������û�������ӵĶ��������û�о�д��һ��Ԥ����Ϣ�����ݿ�
		GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(2, -Integer.parseInt("3"));
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Map map=new HashMap();
		map.put("orderTimeFrom", df.format(gc.getTime()));
		List<Order> orders_1=orderDao.findOrder(map);
		if(orders_1.isEmpty()){
			Message m=new Message();
			m.setContent("�Ѿ�������û���¶�����");
			m.setCreateTime(new Date());
			m.setType(0);
			m.setState(0);
			messageDao.addMessage(m);
		}
		map.clear();
		map.put("state", 0);
		List<Order> orders_2=orderDao.findOrder(map);
		if(!orders_2.isEmpty()){
			Message m=new Message();
			m.setContent("������δ�ؿ�Ķ���");
			m.setCreateTime(new Date());
			m.setType(0);
			m.setState(0);
			messageDao.addMessage(m);
		}
		
	}

//	@Override
//	public void processOrderMessage(Integer id) {
//		// TODO Auto-generated method stub
//		Message m=messageDao.findById(id);
//		m.setProcTime(new Date());
//		
//	}
	
	
	
	

}
