package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.Category;
import com.netease.course.model.Product;

public interface ProductDao extends BaseDao<Product> {

	List<Product> getlist(Category category);

	List<Product> getlist();
 	
}
