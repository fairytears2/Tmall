package com.netease.course.service;

import java.util.List;


import com.netease.course.model.Product;
import com.netease.course.model.PropertyValue;

public interface PropertyValueService extends BaseService<PropertyValue> {

	
	public List<PropertyValue> list(Product product);
	
}
