package com.java1234.security;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.util.StringUtil;

/**
 * �������Ҫ���û���¼��֤
 * 
 */
public class MyAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	/**
	 * ��¼�ɹ�����ת�ĵ�ַ
	 */
	private String successUrl = "/main.jsp";
	/**
	 * ��¼ʧ�ܺ���ת�ĵ�ַ
	 */
	private String errorUrl = "/deniedpage.jsp";
	@Autowired
	private UserDao userDao;
	
	/**
	 * �Զ����������name���ԣ�Ĭ���� j_username �� j_password
	 * �����¼�ɹ���ʧ�ܵ���ת��ַ
	 * @author LJN
	 * Email: mmm333zzz520@163.com
	 * @date 2013-12-5 ����7:02:32
	 */
	public void init() {
		System.err.println(" ---------------  MyAuthenticationFilter init--------------- ");
		this.setUsernameParameter(USERNAME);
		this.setPasswordParameter(PASSWORD);
		// ��֤�ɹ�����ת��ҳ��
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setDefaultTargetUrl(successUrl);
		this.setAuthenticationSuccessHandler(successHandler);

		// ��֤ʧ�ܣ���ת��ҳ��
		SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
		failureHandler.setDefaultFailureUrl(errorUrl);
		this.setAuthenticationFailureHandler(failureHandler);
		System.err.println(" ---------------  MyAuthenticationFilter init finished--------------- ");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		System.out.println(" ---------------  MyAuthenticationFilter attemptAuthentication--------------- ");
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request).trim();
		if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
			BadCredentialsException exception = new BadCredentialsException(
					"�˺Ż����벻��Ϊ�գ�");// �ڽ�������Զ������Ϣ����
			throw exception;
		}

		// ��֤�û��˺��������Ƿ���ȷ
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", username);
		User account = this.userDao.findUser(map).iterator().next();
		if (account == null || (account != null && !account.getPassword().equals(password))) {
			BadCredentialsException exception = new BadCredentialsException(
					"�˺��������벻ƥ�䣡");// �ڽ�������Զ������Ϣ����
			throw exception;
		}
		// ����֤��ͨ���󣬰��û���Ϣ����session��
		System.out.println(("��֤ͨ���ˣ�"));
		request.getSession().setAttribute("accountSession", account);
		// ��¼��¼��Ϣ
		// ʵ�� Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		// ��������������ϸ����
		setDetails(request, authRequest);

		// ����UserDetailsService��loadUserByUsername �ٴη�װAuthentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
}
