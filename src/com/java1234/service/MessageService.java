package com.java1234.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.java1234.entity.Message;


public interface MessageService {
	
	
	public List<Message> findMessage(Map<String,Object> map);
	
	
	public Long getTotalMessage(Map<String,Object> map);
	
	
	public int addMessage(Message message);
	
	
	public int updateMessage(Message message);
	
	/**
	 * 对已经产生的订单信息进行处理
	 * 即填写其处理时间procTime,将state改为1
	 */
	public void processOrderMessage(Integer id);

}
