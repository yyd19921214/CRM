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
import com.java1234.service.ReciptService;
import com.java1234.service.impl.DynamicScheduler;
import com.java1234.util.ResponseUtil;


@Controller
@RequestMapping("/quartz")
public class QuartzController {
	
	@Resource
	private DynamicScheduler dynamicScheduler;
	
	@RequestMapping("/start")
	public String start(HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		dynamicScheduler.start();
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/pause")
	public String pause(HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		dynamicScheduler.pause();
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/isAlive")
	public String isAlive(HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		boolean b=dynamicScheduler.isAlive();
		JSONObject result=new JSONObject();
		result.put("success", true);
		result.put("isAlive", b);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/setTime")
	public String setTime(String cronExpression,HttpServletResponse response)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		cronExpression="0 0/4 * * * ?";
		dynamicScheduler.changeTime(cronExpression);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
