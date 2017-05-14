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

import com.java1234.entity.Order;
import com.java1234.entity.PageBean;
import com.java1234.entity.Recipt;
import com.java1234.service.ReciptService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;


/**
 * 
 * @author yyd
 * �ֿ�䶯����Controller��
 *
 */
@Controller
@RequestMapping("/recipt")
public class ReciptController {
	@Resource
	private ReciptService reciptService;
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:���������ֵ��false:����Ϊ��ֵ
	}
	
	/**
	 * ��ѯ���ݼ�¼����
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,@RequestParam(value="warehouseId",required=false)String warehouseId,@RequestParam(value="productId",required=false)String productId,@RequestParam(value="warehouseName",required=false)String warehouseName,@RequestParam(value="productName",required=false)String productName,Recipt s_recipt,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("changeType",s_recipt.getChangeType());
		map.put("count" , s_recipt.getCount());
		map.put("person", StringUtil.formatLike(s_recipt.getPerson()));
		map.put("warehouseId" , warehouseId);
		map.put("productId" , productId);
		map.put("warehouseName", StringUtil.formatLike(warehouseName));
		map.put("productName", StringUtil.formatLike(productName));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Recipt> reciptList=reciptService.findRecipt(map);
		Long total=reciptService.getTotalRecipt(map);
//		System.out.println(reciptList.size());
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
//		jsonConfig.setExcludes(new String[]{"customer"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(reciptList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ��ӵ��ݼ�¼
	 * @param recipt
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Recipt recipt,HttpServletResponse response)throws Exception{
		
		int resultTotal=0; // �����ļ�¼����
		if(recipt.getId()==null){
			resultTotal=reciptService.addRecipt(recipt);
		}else{
			resultTotal=reciptService.updateRecipt(recipt);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // ִ�гɹ�
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ɾ�����ݼ�¼
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String[] temp=ids.split(",");
		for(int i=0;i<temp.length;i++){
			reciptService.deleteRecipt(Integer.parseInt(temp[i]));
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	/**
	 * ͨ��id���ҵ��ݼ�¼
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		Recipt recipt=reciptService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject=JSONObject.fromObject(recipt,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	/**
	 * ͨ���ֿ����ƻ���Ʒ���Ʋ��ҵ��ݼ�¼
	 * @param warehouseName
	 * @param productName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByProperty")
	public String findByProperty(@RequestParam(value="warehouseName",required=false)String warehouseName,@RequestParam(value="productName",required=false)String productName,HttpServletResponse response)throws Exception{
		Map map=new HashMap();
		map.put("warehouseName", warehouseName);
		map.put("productName", productName);
		Recipt recipt=reciptService.findByProperty(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject=JSONObject.fromObject(recipt,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	/**
	 * ͨ����Ʒ���Ʋ��ҵ��ݼ�¼
	 * @param productName
	 * @param response
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("/findByProductName")
//	public String findByProductName(@RequestParam(value="productName")String productName,HttpServletResponse response)throws Exception{
//		Recipt recipt=reciptService.findByProductName(productName);
//		if(recipt==null){
//			System.out.println(1111);
//		}
//		JsonConfig jsonConfig=new JsonConfig();
//		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
//		JSONObject jsonObject=JSONObject.fromObject(recipt,jsonConfig);
//		ResponseUtil.write(response, jsonObject);
//		return null;
//	}

}
