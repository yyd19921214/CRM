package com.java1234.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ProductDao;
import com.java1234.dao.ReciptDao;
import com.java1234.entity.Product;
import com.java1234.entity.Recipt;
import com.java1234.service.ReciptService;


@Service("reciptService")
public class ReciptServiceImpl implements ReciptService {
	
	@Resource
	private ReciptDao reciptDao;
	@Resource
	private ProductDao productDao;

	@Override
	public List<Recipt> findRecipt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return reciptDao.findRecipt(map);
	}

	@Override
	public Long getTotalRecipt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return reciptDao.getTotalRecipt(map);
	}

	@Override
	public int addRecipt(Recipt recipt) {
		// TODO Auto-generated method stub
		return reciptDao.addRecipt(recipt);
	}

	@Override
	public int updateRecipt(Recipt recipt) {
		// TODO Auto-generated method stub
		return reciptDao.updateRecipt(recipt);
	}

	@Override
	public int deleteRecipt(Integer id) {
		// TODO Auto-generated method stub
		return reciptDao.deleteRecipt(id);
	}

	@Override
	public Recipt findById(Integer id) {
		// TODO Auto-generated method stub
		return reciptDao.findById(id);
	}
	
	

	@Override
	public Recipt findByProperty(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return reciptDao.findByProperty(map);
	}
	
	


	@Override
	public void adjustProduct() {
		HashMap map=new HashMap();
		List<Recipt> reciptList=reciptDao.findRecipt(map);
		for(Recipt r:reciptList){
			if((r.getRemark()==null)||(r.getRemark()!="adjusted")){
				r.setRemark("adjusted");
				reciptDao.updateRecipt(r);
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
