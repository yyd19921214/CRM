package com.java1234.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java1234.dao.ResourcesDao;
import com.java1234.dao.UserDao;
import com.java1234.entity.Resources;
import com.java1234.util.PropertiesUtils;


@Service
public class MyUserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private ResourcesDao resourcesDao ;
	// 登录验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername ----------- ");
		
		//取得用户的权限(这个User是项目的)
		HashMap<String,Object> map=new HashMap<String,Object>();
		com.java1234.entity.User users =userDao.findUser(map).iterator().next();
		if  (users==null)  
            throw new UsernameNotFoundException(username+" not exist!");  
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		// 封装成spring security的user(这里的User类是spring security自带的)
		User userdetail = new User(
				users.getUserName(), 
				users.getPassword(),
				true,  //账号状态  0 表示停用  1表示启用
				true, 
				true,
				true, 
				grantedAuths	//用户的权限
			);
		System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername finished----------- ");
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(com.java1234.entity.User user) {
		List<Resources> menus =null;
		if(PropertiesUtils.findPropertiesKey("rootName").equals(user.getUserName())){//根据账号拥有所有权限
			menus = resourcesDao.queryAll();
		}else{
//			menus = resourcesDao.queryResourcesByUser(user.getRoleName());
			menus = resourcesDao.queryAll();
		}
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (Resources res : menus) {
			// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getResKey()));
		}
		return authSet;
	}

}
