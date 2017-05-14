package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.DataDic;

/**
 * �����ֵ�Service�ӿ�
 * @author Administrator
 *
 */
public interface DataDicService {

	/**
	 * ��ѯ�����ֵ�
	 * @param map
	 * @return
	 */
	public List<DataDic> findDataDic(Map<String,Object> map);
	
	/**
	 * �������Ե������ֵ�����
	 * @return
	 */
	public List<DataDic> findAllDataDicName();
	
	/**
	 * ��ѯ�����ֵ��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalDataDic(Map<String,Object> map);
	
	/**
	 * ��������ֵ�
	 * @param dataDic
	 * @return
	 */
	public int addDataDic(DataDic dataDic);
	
	/**
	 * �޸������ֵ�
	 * @param dataDic
	 * @return
	 */
	public int updateDataDic(DataDic dataDic);
	
	/**
	 * ɾ�������ֵ�
	 * @param id
	 * @return
	 */
	public int deleteDataDic(Integer id);
}
