package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.LinkMan;

/**
 * ��ϵ��Dao�ӿ�
 * @author Administrator
 *
 */
public interface LinkManDao {

	/**
	 * ��ѯ��ϵ��
	 * @param map
	 * @return
	 */
	public List<LinkMan> findLinkMan(Map<String,Object> map);
	
	/**
	 * ��ѯ��ϵ�˼�¼��
	 * @param map
	 * @return
	 */
	public Long getTotalLinkMan(Map<String,Object> map);
	
	/**
	 * �����ϵ��
	 * @param linkMan
	 * @return
	 */
	public int addLinkMan(LinkMan linkMan);
	
	/**
	 * �޸���ϵ��
	 * @param linkMan
	 * @return
	 */
	public int updateLinkMan(LinkMan linkMan);
	
	/**
	 * ɾ����ϵ��
	 * @param id
	 * @return
	 */
	public int deleteLinkMan(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public LinkMan findById(Integer id);
}
