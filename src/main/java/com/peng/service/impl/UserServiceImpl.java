package com.peng.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peng.entity.Role;
import com.peng.entity.User;
import com.peng.entity.UserRole;
import com.peng.mapper.UserMapper;
import com.peng.mapper.UserRoleMapper;
import com.peng.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired private UserMapper userMapper;
	@Autowired private UserRoleMapper userRoleMapper;
	
	public User queryUserByName(String username){
		return userMapper.queryUserByName(username);
	}
	public Set<String> queryRolesByUserName(String username){
		return userMapper.queryRolesByName(username);
	}
	public User findById(long id) {
		return userMapper.findUserById(id);
	}
	@Transactional
	public void deleteUser(long id) {
		userMapper.deleteUser(id);
	}
	public List<User> list() {
		return userMapper.listUser();
	}
	public Set<String> listRoles(Long userid) {
		return null;
	}
	@Transactional
	public int save(User user) {
		int count = userMapper.save(user);
		Long userid = user.getId();
		List<Long> roleids = user.getRoleids();
		userRoleMapper.removeByUserId(userid);
		List<UserRole> list = new ArrayList<UserRole>();
		for (Long roleid : roleids) {
			UserRole userRole = new UserRole();
			userRole.setUserid(userid);
			userRole.setRoleid(roleid);
			list.add(userRole);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return count;
	}
	@Transactional
	public int update(User user) {
		int count = userMapper.update(user);
		Long userid = user.getId();
		List<Long> roleids = user.getRoleids();
		userRoleMapper.removeByUserId(userid);
		List<UserRole> list = new ArrayList<UserRole>();
		for (Long roleid : roleids) {
			UserRole userRole = new UserRole();
			userRole.setUserid(userid);
			userRole.setRoleid(roleid);
			list.add(userRole);
		}
		if (list.size() > 0) {
			userRoleMapper.batchSave(list);
		}
		return count;
	}
	public int remove(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Set<String> queryPermissionByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
