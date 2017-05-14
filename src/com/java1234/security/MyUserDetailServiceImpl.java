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
	// ��¼��֤
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername ----------- ");
		
		//ȡ���û���Ȩ��(���User����Ŀ��)
		HashMap<String,Object> map=new HashMap<String,Object>();
		com.java1234.entity.User users =userDao.findUser(map).iterator().next();
		if  (users==null)  
            throw new UsernameNotFoundException(username+" not exist!");  
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		// ��װ��spring security��user(�����User����spring security�Դ���)
		User userdetail = new User(
				users.getUserName(), 
				users.getPassword(),
				true,  //�˺�״̬  0 ��ʾͣ��  1��ʾ����
				true, 
				true,
				true, 
				grantedAuths	//�û���Ȩ��
			);
		System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername finished----------- ");
		return userdetail;
	}

	// ȡ���û���Ȩ��
	private Set<GrantedAuthority> obtionGrantedAuthorities(com.java1234.entity.User user) {
		List<Resources> menus =null;
		if(PropertiesUtils.findPropertiesKey("rootName").equals(user.getUserName())){//�����˺�ӵ������Ȩ��
			menus = resourcesDao.queryAll();
		}else{
//			menus = resourcesDao.queryResourcesByUser(user.getRoleName());
			menus = resourcesDao.queryAll();
		}
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (Resources res : menus) {
			// TODO:ZZQ �û����Է��ʵ���Դ���ƣ�����˵�û���ӵ�е�Ȩ�ޣ� ע�⣺����"ROLE_"��ͷ
			// �������룺applicationContext-security.xml
			// �������룺com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getResKey()));
		}
		return authSet;
	}

}
