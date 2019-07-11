package com.peng.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.peng.entity.User;

@Service
public interface UserService {
	public User queryUserByName(String username);
	public Set<String> queryRolesByUserName(String username);
	public User findById(long id);
	public void deleteUser(long id);
	public List<User> list();
	public Set<String> listRoles(Long userid);
	public int save(User user);
	public int update(User user);
	public int remove(Long id);
	public Set<String> queryPermissionByUserName(String username);
}
