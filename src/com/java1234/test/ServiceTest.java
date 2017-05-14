package com.java1234.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.java1234.entity.Log;
import com.java1234.entity.Message;
import com.java1234.service.LogService;
import com.java1234.service.MessageService;
import com.java1234.service.OrderService;
import com.java1234.service.impl.DynamicScheduler;


public class ServiceTest {
	
	
	
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        new String[] {"applicationContext.xml"});
		
		MessageService Ser=(MessageService)ctx.getBean("messageService");
		Map<String,Object> map=new HashMap<String,Object>();
		Integer state=1;
		map.put("state", state);
		List<Message> messageList=Ser.findMessage(map);
//		Ser.start();
//		orderSer.checkOrder();
		System.out.println("------------------"+messageList.size());
		
//		LogService logService = (LogService)ctx.getBean("logService");
//		
//		Log log=new Log();
//		log.setAction("add");
//		log.setActionTime(new Date());
//		log.setUserId(1);
//		log.setUserIp("127.0.0.1");
//		
//		logService.addLog(log);
//		System.out.println("已完成日志记载");
		
		
	}

}
