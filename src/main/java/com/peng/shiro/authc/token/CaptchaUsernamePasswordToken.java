package com.peng.shiro.authc.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.peng.enums.UserType;

/**
 * 自定义用户登录权限令牌
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月1日 下午6:44:00
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String captcha; // 验证码
	private UserType type;
	public CaptchaUsernamePasswordToken(String username,String password,
			boolean rememberMe,String captcha,UserType type) {
		super();
		this.captcha = captcha;
		//this.type =type;
		this.setType(type);
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
}
