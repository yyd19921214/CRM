package com.java1234.rmi;

import java.util.List;
import java.util.Map;

import com.java1234.entity.User;

public interface IUserDao {
	public List<User> getUserList(Map map);
	public void saveUser(User user);

}
