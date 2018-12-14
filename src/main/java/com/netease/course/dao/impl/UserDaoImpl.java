package com.netease.course.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.netease.course.dao.UserDao;
import com.netease.course.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	@Override
	public List<User> getList() {
		String jpql = "from User";
		return super.list(jpql, null, null);
	}

	@Override
	public User load(String name) {
		String jpql = "from User u where u.name = ?";
		return (User) super.queryByjpql(jpql, new Object[]{name}, null);
	}

	
}
