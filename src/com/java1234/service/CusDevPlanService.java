package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CusDevPlan;

/**
 * �ͻ������ƻ�Service�ӿ�
 * @author Administrator
 *
 */
public interface CusDevPlanService {

	/**
	 * ��ѯ�ͻ������ƻ�
	 * @param map
	 * @return
	 */
	public List<CusDevPlan> findCusDevPlan(Map<String,Object> map);
	
	/**
	 * ��ѯ�ͻ������ƻ���¼��
	 * @param map
	 * @return
	 */
	public Long getTotalCusDevPlan(Map<String,Object> map);
	
	/**
	 * ��ӿͻ������ƻ�
	 * @param cusDevPlan
	 * @return
	 */
	public int addCusDevPlan(CusDevPlan cusDevPlan);
	
	/**
	 * �޸Ŀͻ������ƻ�
	 * @param cusDevPlan
	 * @return
	 */
	public int updateCusDevPlan(CusDevPlan cusDevPlan);
	
	/**
	 * ɾ���ͻ������ƻ�
	 * @param id
	 * @return
	 */
	public int deleteCusDevPlan(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public CusDevPlan findById(Integer id);
}
