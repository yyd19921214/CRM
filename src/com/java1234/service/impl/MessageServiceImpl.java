package com.java1234.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java1234.dao.ContactDao;
import com.java1234.dao.MessageDao;
import com.java1234.entity.Message;
import com.java1234.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDao messageDao;
	
	

	@Override
	public List<Message> findMessage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return messageDao.findMessage(map);
	}

	@Override
	public Long getTotalMessage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return messageDao.getTotalMessage(map);
	}

	@Override
	public int addMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.addMessage(message);
	}

	@Override
	public int updateMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.updateMessage(message);
	}

	@Override
	public void processOrderMessage(Integer id) {
		// TODO Auto-generated method stub
		Message m=messageDao.findById(id);
		m.setProcTime(new Date());
		m.setState(1);
		messageDao.updateMessage(m);
	}
	
	
	

}
