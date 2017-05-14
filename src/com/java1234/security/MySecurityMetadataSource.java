package com.java1234.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.java1234.dao.ResourcesDao;
import com.java1234.entity.Resources;


@Service
public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private ResourcesDao resourcesDao ;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0)
			throws IllegalArgumentException {
//		System.err.println("-----------MySecurityMetadataSource getAttributes ----------- ");
		String requestUrl = ((FilterInvocation) arg0).getRequestUrl();
		if(resourceMap == null) {
			loadResourceDefine();
		}
		System.out.println("here");
		if(requestUrl.indexOf("?")>-1){
			requestUrl=requestUrl.substring(0,requestUrl.indexOf("?"));
			System.out.println(requestUrl);
		}
		Collection<ConfigAttribute> configAttributes = resourceMap.get(requestUrl);
		return configAttributes;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * @PostConstruct��Java EE 5�����ע�⣬
	 * Spring�����������ܹ�Bean��ʹ��������DI����ʵ������ǰ�ܹ�Beanʱ��
	 * @PostConstructע��ķ����ᱻ�Զ��������Ӷ����һЩ��ʼ��������
	 * 
	 * //����������Դ��Ȩ�޵Ĺ�ϵ
	 */
	@PostConstruct
	private void loadResourceDefine() {
		System.err.println("-------CRM------MySecurityMetadataSource loadResourceDefine -----");
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resources> menus = resourcesDao.queryAll();
			for (Resources m : menus) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				// TODO:ZZQ ͨ����Դ��������ʾ�����Ȩ�� ע�⣺����"ROLE_"��ͷ
				ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + m.getResKey());
				configAttributes.add(configAttribute);
				resourceMap.put(m.getResUrl(), configAttributes);
			}
		}
		System.err.println("-------CRM------MySecurityMetadataSource loadResourceDefine finished-----");
	}
	

}
