package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Contact;

/**
 * ������¼Service�ӿ�
 * @author Administrator
 *
 */
public interface ContactService {

	/**
	 * ��ѯ������¼
	 * @param map
	 * @return
	 */
	public List<Contact> findContact(Map<String,Object> map);
	
	/**
	 * ��ѯ������¼��¼��
	 * @param map
	 * @return
	 */
	public Long getTotalContact(Map<String,Object> map);
	
	/**
	 * ��ӽ�����¼
	 * @param contact
	 * @return
	 */
	public int addContact(Contact contact);
	
	/**
	 * �޸Ľ�����¼
	 * @param contact
	 * @return
	 */
	public int updateContact(Contact contact);
	
	/**
	 * ɾ��������¼
	 * @param id
	 * @return
	 */
	public int deleteContact(Integer id);
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @return
	 */
	public Contact findById(Integer id);
}
