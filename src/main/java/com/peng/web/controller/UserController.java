package com.peng.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peng.dto.rep.SimpleMsgDTO;
import com.peng.entity.Role;
import com.peng.entity.User;
import com.peng.service.RoleService;
import com.peng.service.UserService;
import com.peng.utils.EncryptUtil;

@Controller
@RequestMapping("/sys/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private RoleService roleService;
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	@ResponseBody
	public List<User> list(){
		List<User> list = userService.list();
		return list;
	}
	
	@RequiresPermissions("sys:user:add")
	@GetMapping("/toadd")
	String toadd(Model model) {
		List<Role> roles = roleService.list();
		model.addAttribute("roles", roles);
		return "sys/user/add";
	}
	@RequiresPermissions("sys:user:add")
	@PostMapping("/save")
	@ResponseBody
	SimpleMsgDTO save(User user) {
		SimpleMsgDTO msgDTO=new SimpleMsgDTO();
		user.setPassword(EncryptUtil.encodeMD5Str(user.getPassword()));
		if (userService.save(user) > 0) {
			msgDTO.setCode(1);
			msgDTO.setMsg("ok");
			return msgDTO;
		}else {
			msgDTO.setCode(0);
			msgDTO.setMsg("error");
			return msgDTO;
		}
	}

}
