package com.netease.course.service;

import java.util.List;


import com.netease.course.model.User;



public interface UserService extends BaseService<User> {

	
	public List<User> list();

	public List<User> getUsers();

	public User load(String name);
	
}
