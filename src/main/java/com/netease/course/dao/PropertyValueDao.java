package com.netease.course.dao;

import java.util.List;


import com.netease.course.model.Product;
import com.netease.course.model.PropertyValue;

public interface PropertyValueDao extends BaseDao<PropertyValue> {

	public List<PropertyValue> list(Product product) ;
	
}
