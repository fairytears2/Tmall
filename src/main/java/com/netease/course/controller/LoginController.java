package com.netease.course.controller;

import javax.servlet.http.HttpSession;

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
public class LoginController {

	@Autowired
	UserService userService;
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestBody User loginUser,HttpSession session) {

		String password = SecurityUtil.sha_1(loginUser.getPassword());
		User user = userService.load(loginUser.getName());
		session.setAttribute("user", user);
		String str = "error";
		if(user != null ) {
			if(user.getPassword().equals(password)) {
				str= "ok";
			}
		}
		return str;
	}
	
	

	
	
	
}
