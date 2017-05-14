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

import com.java1234.entity.Contact;
import com.java1234.entity.CusDevMethod;
import com.java1234.service.CusDevMethodService;
import com.java1234.util.ResponseUtil;



@Controller
@RequestMapping("/cusDevMethod")
public class CusDevMethodController {
	
	@Resource
	private CusDevMethodService methodService;
	
	
	@RequestMapping("/list")
	public String list(HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		List<CusDevMethod> methodList=methodService.findCusDevMethod(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(methodList);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(CusDevMethod method,HttpServletResponse response)throws Exception{
		if(method.getId()==null){
			methodService.addCusDevMethod(method);
		}else{
			methodService.updateCusDevMethod(method);
		}
		JSONObject result=new JSONObject();
	    result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	

}
