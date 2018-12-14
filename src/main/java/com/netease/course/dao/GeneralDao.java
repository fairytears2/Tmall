package com.netease.course.dao;

import java.util.List;


import com.netease.course.model.Pager;



public interface GeneralDao<T> extends BaseDao<T> {

	
	public int getTotal(T t) ;
	
	public List<T> getlist(T t);
	
	public Pager<T> getPager(T t);

}
