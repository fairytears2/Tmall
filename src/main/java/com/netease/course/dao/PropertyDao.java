package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.model.Property;

public interface PropertyDao extends BaseDao<Property>{
	
	public int getTotal();
	
	public List<Property> getlist();
	
	public Pager<Property> getPager();

	public List<Property> getlist(Category category);
}
