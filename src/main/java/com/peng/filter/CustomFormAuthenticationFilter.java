package com.peng.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.peng.enums.UserType;
import com.peng.shiro.authc.token.CaptchaUsernamePasswordToken;

/**
 * 自定义认证过滤器
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月22日 下午8:22:27
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	public static final String DEFAULT_TYPE_PARAM = "type";
	
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	private String typeParam = DEFAULT_TYPE_PARAM;
	
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		int type = getType(request);
		return new CaptchaUsernamePasswordToken(username, password, rememberMe, captcha, UserType.values()[type]);
	}

	private String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public String getTypeParam() {
		return typeParam;
	}

	private int getType(ServletRequest request) {
		return Integer.valueOf(WebUtils.getCleanParam(request, getTypeParam()));
	}
}
