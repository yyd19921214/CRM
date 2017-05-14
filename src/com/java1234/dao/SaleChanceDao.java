package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.SaleChance;

/**
 * ���ۻ���Dao�ӿ�
 * @author Administrator
 *
 */
public interface SaleChanceDao {

	/**
	 * ��ѯ���ۻ���
	 * @param map
	 * @return
	 */
	public List<SaleChance> findSaleChance(Map<String,Object> map);
	
	/**
	 * ��ѯ���ۻ����¼��
	 * @param map
	 * @return
	 */
	public Long getTotalSaleChance(Map<String,Object> map);
	
	/**
	 * ������ۻ���
	 * @param saleChance
	 */
	public int addSaleChance(SaleChance saleChance);
	
	/**
	 * �޸����ۻ���
	 * @param saleChance
	 * @return
	 */
	public int updateSaleChance(SaleChance saleChance);
	
	/**
	 * ɾ�����ۻ���
	 * @param id
	 * @return
	 */
	public int deleteSaleChance(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);
	
	/**
	 * �޸Ŀͻ�����״̬
	 * @param devResult
	 * @return
	 */
	public int updateSaleChanceDevResult(Map<String,Object> map);
}
