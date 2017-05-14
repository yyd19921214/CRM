package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Recipt;


public interface ReciptService {
	/**
	 * 查询单据记录
	 * @param map
	 * @return
	 */
	public List<Recipt> findRecipt(Map<String,Object> map);
	
	/**
	 * 查询单据记录数
	 * @param map
	 * @return
	 */
	public Long getTotalRecipt(Map<String,Object> map);
	
	/**
	 * 添加单据记录
	 * @param contact
	 * @return
	 */
	public int addRecipt(Recipt recipt);
	
	/**
	 * 修改单据记录
	 * @param contact
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
	 * 通过仓库名称或商品名称查找单据实体
	 * @return
	 */
	public Recipt findByProperty(Map<String,Object> map);
	
	
	/**
	 * 根据单据调整仓库存储商品的数量变动
	 * @param id
	 * @return
	 */
	public void adjustProduct();
	

}
