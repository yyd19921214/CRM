package com.java1234.dao;

import java.util.ArrayList;
import java.util.List;

import com.java1234.entity.DbUser;

public class DbUserDao {
	public DbUser getDatabase(String username) {  
		  
        List<DbUser> users = internalDatabase();  
  
        for (DbUser dbUser : users) {  
            if (dbUser.getUsername().equals(username) == true) {  
            	System.out.println("User found");
                return dbUser;  
            }  
        }  
        System.out.println("User does not exist!");
        throw new RuntimeException("User does not exist!");  
  
    }
	
	private List<DbUser> internalDatabase() {  
		  
        List<DbUser> users = new ArrayList<DbUser>();  
        DbUser user = null;  
  
        user = new DbUser();  
        user.setUsername("admin");  
  
        // "admin"经过MD5加密后  
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");  
        user.setAccess(1);  
  
        users.add(user);  
  
        user = new DbUser();  
        user.setUsername("user");  
  
        // "user"经过MD5加密后  
        user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");  
        user.setAccess(2);  
  
        users.add(user);  
  
        return users;  
  
    }

}
