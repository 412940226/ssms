package com.peng.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peng.entity.Permissions;
import com.peng.service.PermissionsService;

@Controller
@RequestMapping("/sys/perms")
public class PermissionsController {
	@Autowired private PermissionsService permissionsService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<Permissions> list(){
		List<Permissions> list = permissionsService.list();
		return list;
	}
}
