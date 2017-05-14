package com.java1234.rmi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;

@Component
@WebService(serviceName="UserWebService")
public class UserWebServiceEndpoint{
	
	@Autowired
	private UserDao userDao;
	
	@WebMethod
	public ArrayList<User> getUserList(HashMap map){
		return (ArrayList)userDao.findUser(map);
	}

}
