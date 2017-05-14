package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CusDevMethod;


public interface CusDevMethodDao {
public List<CusDevMethod> findCusDevMethod(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ�����������¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCusDevMethod(Map<String,Object> map);
	
	/**
	 * ��ӿͻ���������
	 * @param cusDevPlan
	 * @return
	 */
	public int addCusDevMethod(CusDevMethod cusDevMethod);
	
	/**
	 * �޸Ŀͻ���������
	 * @param cusDevPlan
	 * @return
	 */
	public int updateCusDevMethod(CusDevMethod cusDevMethod);
	
	/**
	 * ɾ���ͻ���������
	 * @param id
	 * @return
	 */
	public int deleteCusDevMethod(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public CusDevMethod findById(Integer id);

}
