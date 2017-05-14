package com.java1234.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java1234.rmi.IUserDao;

public class RmiTest {
	public static void main(String[] args) {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
        IUserDao userDao = (IUserDao) ctx.getBean("userDaoProxy");
        Map map=new HashMap();
        System.out.println(userDao.getUserList(map));  
//        System.out.println(userDao.sum(145, 487));  
   }  

}
