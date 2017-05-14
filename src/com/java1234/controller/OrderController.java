package com.java1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java1234.entity.Customer;
import com.java1234.entity.Order;
import com.java1234.entity.PageBean;
import com.java1234.service.OrderService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;

/**
 * ����Controller��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	/**
	 * ��ѯ��������
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,@RequestParam(value="cusId",required=false)String cusId,HttpServletResponse response)throws Exception{
		if(StringUtil.isEmpty(cusId)){
			return null;
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cusId", cusId);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Order> orderList=orderService.findOrder(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		Long total=orderService.getTotalOrder(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(orderList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	@RequestMapping("/listAll")
	public String listAll(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,Order order,String orderTimeFrom,String orderTimeTo,HttpServletResponse response)throws Exception{
		
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orderNo", order.getOrderNo());
		map.put("state", order.getState());
//		System.out.println(map.get("state"));
		map.put("orderTimeFrom", orderTimeFrom);
		map.put("orderTimeTo", orderTimeTo);
//		System.out.println(orderTimeFrom);
//		map.put("orderDate", order.getOrderDate());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
	
		List<Order> orderList=orderService.findOrder(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		Long total=orderService.getTotalOrder(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(orderList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ͨ��id����ʵ��
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		Order order=orderService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject=JSONObject.fromObject(order,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
