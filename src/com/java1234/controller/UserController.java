package com.java1234.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java1234.entity.PageBean;
import com.java1234.entity.User;
import com.java1234.service.UserService;
import com.java1234.util.ResponseUtil;
import com.java1234.util.StringUtil;
import com.java1234.util.POIUtils;
/**
 * �û�Controller��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	public static List loginAccounts;
	/**
	 * �û���¼
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		if(loginAccounts==null){
			loginAccounts=new ArrayList();
		}
		
		//�˴������ύ�����ݻ��Զ���װΪuser����
		User resultUser=userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "�û������������");
			return "login";
		} else {
			HttpSession session = request.getSession();
			//����Ƿ��Ѿ���¼
			for (int i = 0; i < loginAccounts.size(); i++) {
			    HashMap<String,Object> existAccount = (HashMap<String,Object>)loginAccounts.get(i);
			    if( session.getId().equals(( (String)existAccount.get("sessionId")) ) ){
			    	System.out.println("���û��Ѿ���¼");
			        return "login";
			    }
			}
			//��ʱ���ͨ��
			//��map���������û��������Ϣ�����Ա�־���û�
//			request.getSession().setMaxInactiveInterval(60*30)
			session.setMaxInactiveInterval(60*30);
			HashMap map=new HashMap();
			map.put("userId", resultUser.getId());
			map.put("sessionId", session.getId());
			loginAccounts.add(map);
					
			session.setAttribute("currentUser", resultUser);
			return "redirect:/main.jsp";
		}
	}
	
	/**
	 * ��ȡ�ͻ�������Ϣ �����������õ�
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerManagerComboList")
	public String customerManagerComboList(HttpServletResponse response)throws Exception{
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("trueName", "");
		jsonObject.put("trueName", "��ѡ��...");
		jsonArray.add(jsonObject);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("roleName", "��������");
		List<User> userList=userService.findUser(map);
		JSONArray rows=JSONArray.fromObject(userList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * �޸��û�����
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(User user,HttpServletResponse response)throws Exception{
		int resultTotal=userService.updateUser(user);
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
	 * �û�ע��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
//		String sessionId=session.getId();
//		for (int i = 0; i < loginAccounts.size(); i++) {
//		    HashMap<String,Object> existAccount = (HashMap<String,Object>)loginAccounts.get(i);
//		    if(sessionId.equals(existAccount.get("sessionId"))){
//		        loginAccounts.remove(existAccount);
//		    }
//		}
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	/**
	 * ��ѯ�û�����
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,User s_user,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList=userService.findUser(map);
		Long total=userService.getTotalUser(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ����û�
	 * @param customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user,HttpServletResponse response)throws Exception{
		int resultTotal=0; // �����ļ�¼����
		if(user.getId()==null){
			resultTotal=userService.addUser(user);
		}else{
			resultTotal=userService.updateUser(user);
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
	 * ɾ���û�
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			userService.deleteUser(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * ��������Excel������ʽ������
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletResponse response,Map map) {
		 List<User> users =userService.findUser(map);
		 POIUtils.exportToExcel(response, "�û�����", users, User.class, "�û�", users.size());
	}
	

	
	
	
	
}
