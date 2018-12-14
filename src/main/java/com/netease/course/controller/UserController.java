package com.netease.course.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.netease.course.model.User;

import com.netease.course.service.UserService;
import com.netease.course.uitls.SecurityUtil;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/addregister")
	public String addUser(@RequestBody User user) throws IOException{
		String password = SecurityUtil.sha_1(user.getPassword());
		if(user.getName()!= null && password != null){
			user.setPassword(password);
			userService.add(user);
		}
		return "ok";
	};
	

	
	
	
	
	/**
	 * 获取所有user
	 * @return
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping("/getUser")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	
	
	
}
