package com.java1234.util;

import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.java1234.controller.UserController;

public class ListenerUtil implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("һ���µ�Session������");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		String sessionId = event.getSession().getId();
		for (int i = 0; i < UserController.loginAccounts.size(); i++) {
			HashMap<String, Object> existAccount = (HashMap<String, Object>) UserController.loginAccounts.get(i);
			if (sessionId.equals((String)existAccount.get("sessionId"))) {
				UserController.loginAccounts.remove(existAccount);
			}
		}
		System.out.println("session�Ѿ�������");
//		System.out.println("һ��session��������");
		// TODO Auto-generated method stub
		
	}
	

}
