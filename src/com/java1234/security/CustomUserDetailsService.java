package com.java1234.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User; 

import com.java1234.dao.DbUserDao;
import com.java1234.entity.DbUser;

public class CustomUserDetailsService implements UserDetailsService{
//	protected static Logger logger = Logger.getLogger("service"); 
	 private DbUserDao userDAO = new DbUserDao();  

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserDetails user = null;
		
		try {  
			  
            // 搜索数据库以匹配用户登录名.  
            // 我们可以通过dao使用JDBC来访问数据库  
            DbUser dbUser = userDAO.getDatabase(username);  
  
  
			user = new User(dbUser.getUsername(), dbUser.getPassword()
					.toLowerCase(), true, true, true, true,
					getAuthorities(dbUser.getAccess()));
  
        } catch (Exception e) {  
//            logger.error("Error in retrieving user");
        	System.out.println("Error in retrieving user");
            throw new UsernameNotFoundException("Error in retrieving user");  
        }  
		
		// TODO Auto-generated method stub
		return user;
	}
	
	public Collection<GrantedAuthority> getAuthorities(Integer access) {  
		  
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);  
  
        // 所有的用户默认拥有ROLE_USER权限  
//        logger.debug("Grant ROLE_USER to this user");
        System.out.println("Grant ROLE_USER to this user");
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));  
  
        // 如果参数access为1.则拥有ROLE_ADMIN权限  
        if (access.compareTo(1) == 0) {  
//            logger.debug("Grant ROLE_ADMIN to this user");
        	 System.out.println("Grant ROLE_ADMIN to this user");
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));  
        }  
  
        return authList;  
    }  
	
	

}
