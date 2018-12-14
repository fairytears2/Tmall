package com.netease.course.service;

import java.util.List;

import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.model.Product;

public interface ProductService extends BaseService<Product> {

	public int getTotal();
	
	public List<Product> getlist(Category category);
	
	public Pager<Product> getPager();
	
}
