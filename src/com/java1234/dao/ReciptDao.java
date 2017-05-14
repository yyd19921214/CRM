package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Recipt;


/**
 * 
 * @author yyd
 * 单据Dao层的接口
 *
 */
public interface ReciptDao {
	/**
	 * 查询单据记录
	 * @param map
	 * @return
	 */
	public List<Recipt> findRecipt(Map<String,Object> map);
	
	/**
	 * 查询仓库变动单据记录数
	 * @param map
	 * @return
	 */
	public Long getTotalRecipt(Map<String,Object> map);
	
	/**
	 * 添加单据记录
	 * @param recipt
	 * @return
	 */
	public int addRecipt(Recipt recipt);
	
	/**
	 * 修改单据记录
	 * @param recipt
	 * @return
	 */
	public int updateRecipt(Recipt recipt);
	
	/**
	 * 删除单据记录
	 * @param id
	 * @return
	 */
	public int deleteRecipt(Integer id);
	
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public Recipt findById(Integer id);
	
	/**
	 * 通过仓库名称或商品名称查找实体
	 * @param warehouseName
	 * @return
	 */
	public Recipt findByProperty(Map<String,Object> map);
	

}
