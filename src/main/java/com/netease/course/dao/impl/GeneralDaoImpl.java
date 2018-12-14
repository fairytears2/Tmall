package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.GeneralDao;
import com.netease.course.model.Pager;


@Repository("generalDao")
public class GeneralDaoImpl<T> extends BaseDaoImpl<T> implements GeneralDao<T>{

	public int getTotal(T t) {
		String name = t.getClass().getName();
		String jpql = "select count(*) from" + name;
		return (int) super.queryByjpql(jpql, null, null);
	}

	public List<T> getlist(T t){
		String name = t.getClass().getName();
		String jpql = "from" + name;
		return list(jpql, null, null);		
	}
	
	public Pager<T> getPager(T t){
		String name = t.getClass().getName();
		String jpql = "from" + name;;
		return find(jpql, null, null);
	}
	
	
}
