package com.peng.shiro;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.peng.entity.User;

/**
 * 存放于shiro里面的session
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月1日 下午4:46:14
 */
public class ShiroUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static long getUserId(){
		return getShiroUser().getId();
	}
	public static User getShiroUser(){
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
	public static void setSessionAttribute(Object key,Object value){
		getSession().setAttribute(key, value);
	}
	public static Object getSessionAttribute(Object key){
		return getSession().getAttribute(key);
	}
	public static String getKaptcha(Object key){
		return getSessionAttribute(key).toString();
	}
	public static void logout(){
		SecurityUtils.getSubject().logout();
	}
}
