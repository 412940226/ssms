package com.peng.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.peng.entity.Permissions;

@Service
public interface PermissionsService {
	Permissions get(Long id);
	List<Permissions> list();
	int remove(Long id);
	int save(Permissions permissions);
	int update(Permissions permissions);
	Set<String> listPerms(Long userId);
}
