package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ContactDao;
import com.java1234.dao.CusDevMethodDao;
import com.java1234.entity.CusDevMethod;
import com.java1234.service.CusDevMethodService;

@Service("cusDevMethodService")
public class CusDevMethodServiceImpl implements CusDevMethodService {
	
	@Resource
	private CusDevMethodDao methodDao;

	@Override
	public List<CusDevMethod> findCusDevMethod(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return methodDao.findCusDevMethod(map);
	}

	@Override
	public int addCusDevMethod(CusDevMethod cusDevMethod) {
		// TODO Auto-generated method stub
		return methodDao.addCusDevMethod(cusDevMethod);
	}

	@Override
	public CusDevMethod findById(Integer id) {
		// TODO Auto-generated method stub
		return methodDao.findById(id);
	}

	@Override
	public int updateCusDevMethod(CusDevMethod cusDevMethod) {
		// TODO Auto-generated method stub
		return methodDao.updateCusDevMethod(cusDevMethod);
	}

}
