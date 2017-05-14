package com.java1234.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java1234.entity.PageBean;
import com.java1234.entity.Warehouse;
import com.java1234.service.WarehouseService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;


/**
 * 
 * @author yyd
 * 仓库记录Controller类
 *
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	
	@Resource
	private WarehouseService warehouseService;
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
	
	/**
	 * 查询仓库记录集合
	 * @param warehouseName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,Warehouse s_warehouse,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("warehouseName", StringUtil.formatLike(s_warehouse.getWarehouseName()));
		map.put("location", StringUtil.formatLike(s_warehouse.getLocation()));
		map.put("manager", StringUtil.formatLike(s_warehouse.getManager()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Warehouse> warehouseList=warehouseService.findWarehouseByProperty(map);
		Long total=warehouseService.getTotalWarehouse(map);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(warehouseList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	@RequestMapping("/count")
	public String count(HttpServletResponse response)throws Exception{
		long count=warehouseService.getTotalWarehouse(null);
		JSONObject result=new JSONObject();
		result.put("rows", count);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加仓库记录
	 * @param warehouse
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Warehouse warehouse,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if(warehouse.getId()==null){
			resultTotal=warehouseService.addWarehouse(warehouse);
		}else{
			resultTotal=warehouseService.updateWarehouse(warehouse);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // 执行成功
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除仓库记录
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String[] temp=ids.split(",");
		for(int i=0;i<temp.length;i++){
			warehouseService.deleteWarehouse(Integer.parseInt(temp[i]));
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 通过id查找实体
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		Warehouse warehouse=warehouseService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		JSONObject jsonObject=JSONObject.fromObject(warehouse,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

}
