package com.java1234.quartz;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.java1234.service.OrderService;

//import com.java1234.service.OrderService;

//@Service("orderCheckJob")
public class OrderCheckJob implements Job{
//	@Resource
//	private OrderService orderService;
//
//	public void setOrderService(OrderService orderService) {
//		this.orderService = orderService;
//	}
	

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        new String[] {"applicationContext.xml"});
		OrderService Ser=(OrderService)ctx.getBean("orderService");
		Ser.checkOrder();
		//System.out.println("hahahahhahahahhah");
	}
	
	
	

}
