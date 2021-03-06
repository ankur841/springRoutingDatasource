package com.raistudies.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raistudies.domain.Aid;
import com.raistudies.domain.User;
import com.raistudies.domain.UserRoles;
import com.raistudies.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService springService;
	
	@RequestMapping("/user.json")
	@ResponseBody
	public List<User> getUser(){
		System.setProperty("db","TESTPORTAL");
		return springService.getUser();
	}
	@RequestMapping("/userrole.json")
	@ResponseBody
	public List<UserRoles> getUserRoles(){
		return springService.getUserRole();
	}	
	@RequestMapping("/aid.json")
	@ResponseBody
	public List<Aid> getAid(){
		System.setProperty("db","FINDAPP");
		return springService.getAid();
	}
	@RequestMapping("/index.html")
	public String index(ModelMap m){
		m.addAttribute("users",springService.getUser());
		return "index";
	}
	@RequestMapping("/completeUser.json")
	@ResponseBody
	public List<User> getCompleteUser(ModelMap m){
		return springService.getCompleteUser();
	}
}
