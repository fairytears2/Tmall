package com.netease.course.service;


public interface BaseService<T> {

	public T add(T t);
	
	public void delete(int id);
	
	
	public void  update(T t);
	
	public T load(int id);
}
