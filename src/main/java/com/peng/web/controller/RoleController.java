package com.peng.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peng.entity.Role;
import com.peng.service.RoleService;

/**
 * 
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月1日 下午5:10:10
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController{
	@Autowired private RoleService roleService;
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	@ResponseBody
	public List<Role> list(){
		List<Role> list = roleService.list();
		return list;
	}
}