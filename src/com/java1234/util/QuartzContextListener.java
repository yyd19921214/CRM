package com.java1234.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;

import com.java1234.service.impl.DynamicScheduler;

/**
 * 
 * @author yyd
 * 该类用来在web容器关闭时关闭QUARTZ引用，以防止内存泄露
 *
 */
public class QuartzContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		WebApplicationContext webApplicationContext = (WebApplicationContext) arg0 .getServletContext().getAttribute(  
         WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
		DynamicScheduler startQuertz = (DynamicScheduler) webApplicationContext  
                .getBean("dynamicScheduler");  
        if(startQuertz != null) {  
            startQuertz.shutDown();
//            System.out.println("it has shuted!!!!!");
        }  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("容器初始化");

	}

}
