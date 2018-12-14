package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.UserDao;
import com.netease.course.dao.impl.BaseDaoImpl;
import com.netease.course.model.User;
import com.netease.course.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> list() {
		return userDao.getList();
	}


	@Override
	public List<User> getUsers() {
		return userDao.getList();
	}


	@Override
	public User load(String name) {
		return userDao.load(name);
	}

	
	
	
}
