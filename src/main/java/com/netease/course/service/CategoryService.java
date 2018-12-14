package com.netease.course.service;

import java.util.List;

import com.netease.course.model.Category;
import com.netease.course.model.Pager;

public interface CategoryService extends BaseService<Category>  {
	
	public int getTotal();
	
	public List<Category> getlist();
	
	public Pager<Category> getPager();
}
