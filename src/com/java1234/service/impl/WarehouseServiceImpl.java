package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.WarehouseDao;
import com.java1234.entity.Warehouse;
import com.java1234.service.WarehouseService;

/**
 * 
 * @author yyd
 * ≤÷ø‚Service µœ÷¿‡
 *
 */
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {
	
	@Resource
	private WarehouseDao warehousedao;

	@Override
	public List<Warehouse> findWarehouseByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return warehousedao.findWarehouseByProperty(map);
	}

	@Override
	public Long getTotalWarehouse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return warehousedao.getTotalWarehouse(map);
	}

	@Override
	public int addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehousedao.addWarehouse(warehouse);
	}

	@Override
	public int updateWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehousedao.updateWarehouse(warehouse);
	}

	@Override
	public int deleteWarehouse(Integer id) {
		// TODO Auto-generated method stub
		return warehousedao.deleteWarehouse(id);
	}

	@Override
	public Warehouse findById(Integer id) {
		// TODO Auto-generated method stub
		return warehousedao.findById(id);
	}

}
