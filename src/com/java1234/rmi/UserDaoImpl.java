package com.java1234.rmi;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;

public class UserDaoImpl implements IUserDao {
	
	@Resource
	private UserDao userDao;

	@Override
	public List<User> getUserList(Map map) {
		// TODO Auto-generated method stub
		return userDao.findUser(map);
	}

	@Override
	public void saveUser(User user) {
		userDao.addUser(user);
		// TODO Auto-generated method stub
		
	}
	
	

}
