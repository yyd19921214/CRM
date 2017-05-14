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
import org.springframework.web.bind.annotation.ResponseBody;

import com.java1234.entity.Message;
import com.java1234.service.MessageService;
import com.java1234.util.ResponseUtil;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="state",required=false)String state,@RequestParam(value="type",required=false)String type,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("state", state);
		map.put("type", type);
		List<Message> messageList=messageService.findMessage(map);
		
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(messageList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/proc")
	public String list(@RequestParam(value="id",required=false)String id,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("state", state);
//		map.put("type", type);
		messageService.processOrderMessage(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
//		JsonConfig jsonConfig=new JsonConfig();
//		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
//		JSONArray jsonArray=JSONArray.fromObject(messageList,jsonConfig);
//		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}

}
