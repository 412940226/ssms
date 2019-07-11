package com.peng.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.entity.Permissions;
import com.peng.mapper.PermissionsMapper;
import com.peng.mapper.RolePermissionsMapper;
import com.peng.service.PermissionsService;

@Service
public class PermissionsServiceImpl implements PermissionsService {
	private static final Logger logger = LoggerFactory.getLogger(PermissionsServiceImpl.class);
	
	@Autowired private PermissionsMapper permissionsMapper;
	@Autowired private RolePermissionsMapper rolePermissionsMapper;
	
	public List<Permissions> list() {
		return permissionsMapper.listPermissions();
	}

	public int remove(Long id) {
		return permissionsMapper.remove(id);
	}

	public int save(Permissions permissions) {
		return permissionsMapper.save(permissions);
	}

	public int update(Permissions permissions) {
		return permissionsMapper.update(permissions);
	}

	public Permissions get(Long id) {
		return permissionsMapper.getPermissions(id);
	}

	public Set<String> listPerms(Long userId) {
		return null;
	}

}
