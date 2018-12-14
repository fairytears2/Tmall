package com.netease.course.dao;


public interface BaseDao<T> {

	public T add(T t);
	
	public void delete(int id);
	
	
	public void  update(T t);
	
	public T load(int id);
	
}
