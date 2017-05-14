package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Log;

public interface LogService {

	public List<Log> findLog(Map<String, Object> map);

	public Long getTotalLog(Map<String, Object> map);

	public int addLog(Log log);

	public int deleteLog(Integer id);

	public Log findById(Integer id);

}
