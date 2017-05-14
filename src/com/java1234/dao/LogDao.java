package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Log;


public interface LogDao {
	/**
	 * ��ѯ��־��¼
	 * @param map
	 * @return
	 */
	public List<Log> findLog(Map<String,Object> map);
	
	/**
	 * ��ѯ��־��¼����
	 * @param map
	 * @return
	 */
	public Long getTotalLog(Map<String,Object> map);
	
	/**
	 * �����־��¼
	 * @param log
	 * @return
	 */
	public int addLog(Log log);
	
	
	/**
	 * ɾ����־��¼
	 * @param id
	 * @return
	 */
	public int deleteLog(Integer id);
	
	/**
	 * ͨ��id������־ʵ��
	 * @param id
	 * @return
	 */
	public Log findById(Integer id);

}
