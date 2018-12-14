package com.netease.course.service;

import java.util.List;

import com.netease.course.model.Pager;
import com.netease.course.model.Product;
import com.netease.course.model.Property;

public interface PropertyService  extends BaseService<Property>{
	public int getTotal();
	
	public List<Property> getlist(Integer id);
	
	public Pager<Property> getPager();

	public List<Property> listname(Product product);
	
}
