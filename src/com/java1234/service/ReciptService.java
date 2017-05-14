package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Recipt;


public interface ReciptService {
	/**
	 * ��ѯ���ݼ�¼
	 * @param map
	 * @return
	 */
	public List<Recipt> findRecipt(Map<String,Object> map);
	
	/**
	 * ��ѯ���ݼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotalRecipt(Map<String,Object> map);
	
	/**
	 * ��ӵ��ݼ�¼
	 * @param contact
	 * @return
	 */
	public int addRecipt(Recipt recipt);
	
	/**
	 * �޸ĵ��ݼ�¼
	 * @param contact
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
	 * ͨ���ֿ����ƻ���Ʒ���Ʋ��ҵ���ʵ��
	 * @return
	 */
	public Recipt findByProperty(Map<String,Object> map);
	
	
	/**
	 * ���ݵ��ݵ����ֿ�洢��Ʒ�������䶯
	 * @param id
	 * @return
	 */
	public void adjustProduct();
	

}
