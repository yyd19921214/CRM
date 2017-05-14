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
import com.java1234.entity.Log;
import com.java1234.service.LogService;
import com.java1234.util.ResponseUtil;

@Controller
@RequestMapping("/log")
public class LogController {
	@Resource
	private LogService logService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="userId")String userId,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", userId);
		List<Log> logList=logService.findLog(map);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(logList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(Log log,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
//		if(contact.getId()==null){
			resultTotal=logService.addLog(log);
//		}else{
//			resultTotal=contactService.updateContact(contact);
//		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // 执行成功
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

}
