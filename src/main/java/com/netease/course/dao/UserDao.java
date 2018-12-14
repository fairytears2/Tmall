package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.User;

public interface UserDao extends BaseDao<User>{

	public List<User> getList();

	public User load(String name);

	
}
