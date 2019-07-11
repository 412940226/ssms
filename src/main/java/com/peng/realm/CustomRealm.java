package com.peng.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peng.entity.User;
import com.peng.service.UserService;
import com.peng.service.impl.UserServiceImpl;

/**
 * 自定义realm
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月1日 下午5:16:30
 */
public class CustomRealm extends AuthorizingRealm{
	private static final Logger logger = LoggerFactory
			.getLogger(CustomRealm.class);
	@Autowired
	private UserService userService;
	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("======================用户授权=========================");
		String username = principalCollection.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(userService.queryRolesByUserName(username));
		simpleAuthorizationInfo.setStringPermissions(userService.queryPermissionByUserName(username));
		return simpleAuthorizationInfo;
	}
	/**
	 * 当前用户登陆的认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info("====================当前用户登录认证=========================");
		String username = authenticationToken.getPrincipal().toString();
		User user = userService.queryUserByName(username);
		if (user!=null) {
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			return authenticationInfo;
		}
		return null;
	}

}
