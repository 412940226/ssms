package com.peng.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peng.entity.Role;
import com.peng.entity.RolePermissions;
import com.peng.mapper.RoleMapper;
import com.peng.mapper.RolePermissionsMapper;
import com.peng.mapper.UserMapper;
import com.peng.mapper.UserRoleMapper;
import com.peng.service.RoleService;
import com.peng.shiro.ShiroUser;

@Service
public class RoleServiceImpl implements RoleService {
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired private RoleMapper roleMapper;
	@Autowired private RolePermissionsMapper rolePermissionsMapper;
	
	@Autowired private UserMapper userMapper;
	@Autowired private UserRoleMapper userRoleMapper;
	
	public Role get(Long id) {
		return roleMapper.get(id);
	}

	public List<Role> list() {
		return roleMapper.listRole();
	}
	@Transactional
	public int save(Role role) {
//		role=new Role();
//		role.setCreatetime(new Date());
//		role.setCreateby(ShiroUser.getShiroUser().getCreateby());
		int count = roleMapper.save(role);
		List<Long> permissionsids = role.getPermissionsids();
		long roleid = role.getId();
		List<RolePermissions> rp=new ArrayList<RolePermissions>();
		for(long permissionsid:permissionsids){
			RolePermissions rolePermissions=new RolePermissions();
			rolePermissions.setRoleid(roleid);
			rolePermissions.setPermissionsid(permissionsid);
//			rolePermissions.setCreatetime(new Date());
//			rolePermissions.setCreateby(ShiroUser.getShiroUser().getCreateby());
			rp.add(rolePermissions);
		}
		rolePermissionsMapper.removeByRoleId(roleid);
		if (rp.size()>0) {
			rolePermissionsMapper.batchSave(rp);
		}
		return count;
	}
	@Transactional
	public int update(Role role) {
//		role=new Role();
//		role.setUpdatetime(new Date());
//		role.setUpdateby(ShiroUser.getShiroUser().getUpdateby());
		int count = roleMapper.update(role);
		List<Long> permissionsids = role.getPermissionsids();
		long roleid = role.getId();
		rolePermissionsMapper.removeByRoleId(roleid);
		List<RolePermissions> rp=new ArrayList<RolePermissions>();
		for(long permissionsid:permissionsids){
			RolePermissions rolePermissions=new RolePermissions();
			rolePermissions.setRoleid(roleid);
			rolePermissions.setPermissionsid(permissionsid);
//			rolePermissions.setUpdatetime(new Date());
//			rolePermissions.setUpdateby(ShiroUser.getShiroUser().getUpdateby());
			rp.add(rolePermissions);
		}
		rolePermissionsMapper.removeByRoleId(roleid);
		if (rp.size()>0) {
			rolePermissionsMapper.batchSave(rp);
		}
		return count;
	}
	@Transactional
	public int remove(Long id) {
		rolePermissionsMapper.remove(id);
		return roleMapper.remove(id);
	}

	public List<Role> list(Long userid) {
		List<Long> roleids = userRoleMapper.listRoleId(userid);
		List<Role> roles = roleMapper.listRole();
		for(Role role:roles){
			role.setRolekey("0");
			for(long roleid:roleids){
				if (role.getId() == roleid) {
					role.setRolekey("1");
					break;
				}
			}
		}
		return roles;
	}

}
