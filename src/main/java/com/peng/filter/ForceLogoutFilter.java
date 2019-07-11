package com.peng.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peng.constant.SessionKey;

/**
 * 
* @ClassName: ForceLogoutFilter 
* @Description: 强制退出拦截器 
* @author pengcq 412940226@qq.com 
* @date 2018年2月21日 下午11:55:22 
*
 */
public class ForceLogoutFilter extends AccessControlFilter{
	private static Logger logger = LoggerFactory.getLogger(AccessControlFilter.class);
	private String loginUrl = "";
	
	@SuppressWarnings("unused")
	private void writeCookie(String name, String value,HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		if (session == null){
			//不存在session,则可以访问
			return true;
		}
		Boolean isForceLogOut = (Boolean) session.getAttribute(SessionKey.SESSION_FORCE_LOGOUT_KEY);
		if (isForceLogOut != null && isForceLogOut == true){
			//被强制退出
			return false;
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		getSubject(request, response).logout();// 强制退出
		WebUtils.issueRedirect(request, response, loginUrl);
		return false;
	}
	
	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

}
