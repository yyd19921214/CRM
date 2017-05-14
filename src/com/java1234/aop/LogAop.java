package com.java1234.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java1234.entity.Log;
import com.java1234.service.LogService;


@Component
@Aspect
public class LogAop {
	
//	static Log log = LogFactory.getLog(LogAop.class);  
	 private static final Logger logger = Logger.getLogger(LogAop.class);
	
	@Autowired
	private LogService logService;
	@Autowired
	private  HttpServletRequest request;
	
	@Pointcut("execution(* com.java1234.dao.*.*(..))")
	public void performance(){
		
	}
	
	@Around("performance()")
	public Object authority(ProceedingJoinPoint  PJ) throws Throwable
    {
		
        System.out.println("=======开始模拟进行日志记录=======") ;
        String methodName = PJ.getSignature().getName();
        	String className = PJ.getTarget().getClass().getSimpleName();
            String userIp=request.getRemoteAddr();
            String action=className+"->"+methodName;
            Date actionTime=new Date();
            
            logger.info(userIp+"action:"+action+"time:"+actionTime.toString());  
        System.out.println("=======结束模拟进行日志记录=======") ;
        
        Object retVal=PJ.proceed();
        return retVal;
        
    }

}
