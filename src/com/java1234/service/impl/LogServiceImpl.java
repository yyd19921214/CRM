package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.LogDao;
import com.java1234.entity.Log;
import com.java1234.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService{
	
	@Resource
	private LogDao logDao;
	

	@Override
	public List<Log> findLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return logDao.findLog(map);
	}

	@Override
	public Long getTotalLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return logDao.getTotalLog(map);
	}

	@Override
	public int addLog(Log log) {
		// TODO Auto-generated method stub
		return logDao.addLog(log);
	}

	@Override
	public int deleteLog(Integer id) {
		// TODO Auto-generated method stub
		return logDao.deleteLog(id);
	}

	@Override
	public Log findById(Integer id) {
		// TODO Auto-generated method stub
		return logDao.findById(id);
	}
	

}
