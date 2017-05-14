package com.java1234.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerTest {
	 public static void main(String[] args) {
		   
		 //ͨ��schedulerFactory��ȡһ��������
		   SchedulerFactory schedulerfactory=new StdSchedulerFactory();
		   Scheduler scheduler=null;
		   try{
//			ͨ��schedulerFactory��ȡһ��������
			   scheduler=schedulerfactory.getScheduler();
			   
//			 ����jobDetailʵ������Jobʵ����
//			 ָ��job�����ƣ�����������ƣ��Լ���job��
			JobDetail job=JobBuilder.newJob(MyJob.class).withIdentity("job1", "jgroup1").build();
			 
			   
//			 ������ȴ�������
			   
//			ʹ��simpleTrigger����
//			Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
//					          .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8))
//					          .startNow().build();
//			ʹ��cornTrigger����  ÿ��10��42��
				  Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
		          .withSchedule(CronScheduleBuilder.cronSchedule("0 38 22 * * ? *"))
		          .startNow().build(); 
			   
//			 ����ҵ�ʹ�����ע�ᵽ���������
			   scheduler.scheduleJob(job, trigger);
			   
//			 ��������
			   scheduler.start();
			   
			   
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   
	}

}
