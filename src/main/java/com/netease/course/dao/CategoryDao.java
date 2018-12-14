package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.Category;
import com.netease.course.model.Pager;

public interface CategoryDao extends BaseDao<Category> {

	public int getTotal();
	
	public List<Category> getlist();
	
	public Pager<Category> getPager();
}
