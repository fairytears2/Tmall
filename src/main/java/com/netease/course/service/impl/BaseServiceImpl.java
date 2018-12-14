package com.netease.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.netease.course.dao.BaseDao;
import com.netease.course.service.BaseService;


public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	BaseDao<T> baseDao;
	
	@Override
	public T add(T t) {
		return baseDao.add(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
		
	}

	@Override
	public T load(int id) {
		return baseDao.load(id);
	}

}
