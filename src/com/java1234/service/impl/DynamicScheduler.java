package com.java1234.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.java1234.quartz.OrderCheckJob;
import com.java1234.util.PropertiesUtils;


@Service("dynamicScheduler")
public class DynamicScheduler {
	static Scheduler scheduler = null;
	static JobDetail job=null;
	static Trigger trigger=null;
	static int flag=0;    //��Ǳ��� 0����ʾ������ͣ  1����ʾ�����Ѿ�������
	static{
		System.out.println("--------��ʼ��Quartz���------");
		String cronExpression=PropertiesUtils.findPropertiesKey("cronExpression");
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		try{
			scheduler = schedulerfactory.getScheduler();

			// ����jobDetailʵ������Jobʵ����
			// ָ��job�����ƣ�����������ƣ��Լ���job��
			job = JobBuilder.newJob(OrderCheckJob.class)
					.withIdentity("job1", "jgroup1").build();
			
			trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(
							CronScheduleBuilder.cronSchedule(cronExpression))
					.startNow().build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
//			scheduler.rescheduleJob(trigger.getKey(),trigger);
			scheduler.pauseJob(job.getKey());
//			flag=1;
		}catch(Exception e){
			
		}
	}
	public void start() {
		try{
			scheduler.resumeJob(job.getKey());
			synchronized(this)
			{
				flag=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void pause(){
		try{
			scheduler.pauseJob(job.getKey());
			synchronized(this)
			{
				flag=0;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isAlive(){
		try{
			synchronized(this)
			{
				if (flag==1){
					return true;
				}
				else{
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void shutDown(){
		try{
			scheduler.shutdown();
			flag=0;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void changeTime(String newcronExpression){
		try{
			trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(
							CronScheduleBuilder.cronSchedule(newcronExpression))
					.startNow().build();
//			scheduler.clear();
//			scheduler.scheduleJob(job, trigger);
			scheduler.rescheduleJob(trigger.getKey(), trigger);
			scheduler.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
