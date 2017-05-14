package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Recipt;


/**
 * 
 * @author yyd
 * ����Dao��Ľӿ�
 *
 */
public interface ReciptDao {
	/**
	 * ��ѯ���ݼ�¼
	 * @param map
	 * @return
	 */
	public List<Recipt> findRecipt(Map<String,Object> map);
	
	/**
	 * ��ѯ�ֿ�䶯���ݼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotalRecipt(Map<String,Object> map);
	
	/**
	 * ��ӵ��ݼ�¼
	 * @param recipt
	 * @return
	 */
	public int addRecipt(Recipt recipt);
	
	/**
	 * �޸ĵ��ݼ�¼
	 * @param recipt
	 * @return
	 */
	public int updateRecipt(Recipt recipt);
	
	/**
	 * ɾ�����ݼ�¼
	 * @param id
	 * @return
	 */
	public int deleteRecipt(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public Recipt findById(Integer id);
	
	/**
	 * ͨ���ֿ����ƻ���Ʒ���Ʋ���ʵ��
	 * @param warehouseName
	 * @return
	 */
	public Recipt findByProperty(Map<String,Object> map);
	

}
