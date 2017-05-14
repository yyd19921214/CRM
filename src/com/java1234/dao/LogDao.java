package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Log;


public interface LogDao {
	/**
	 * 查询日志记录
	 * @param map
	 * @return
	 */
	public List<Log> findLog(Map<String,Object> map);
	
	/**
	 * 查询日志记录总数
	 * @param map
	 * @return
	 */
	public Long getTotalLog(Map<String,Object> map);
	
	/**
	 * 添加日志记录
	 * @param log
	 * @return
	 */
	public int addLog(Log log);
	
	
	/**
	 * 删除日志记录
	 * @param id
	 * @return
	 */
	public int deleteLog(Integer id);
	
	/**
	 * 通过id查找日志实体
	 * @param id
	 * @return
	 */
	public Log findById(Integer id);

}
