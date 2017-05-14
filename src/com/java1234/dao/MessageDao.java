package com.java1234.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.java1234.entity.Contact;
import com.java1234.entity.Message;


public interface MessageDao {
	
	public List<Message> findMessage(Map<String, Object> map);

	public Long getTotalMessage(Map<String, Object> map);

	public int addMessage(Message message);

	public int updateMessage(Message message);
	
	public Message findById(Integer id);

}
