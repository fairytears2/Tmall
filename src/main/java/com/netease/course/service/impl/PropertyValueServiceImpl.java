package com.netease.course.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.ProductDao;
import com.netease.course.dao.PropertyDao;
import com.netease.course.dao.PropertyValueDao;

import com.netease.course.model.Product;

import com.netease.course.model.PropertyValue;
import com.netease.course.service.PropertyValueService;


@Service("propertyValueService")
public class PropertyValueServiceImpl extends BaseServiceImpl<PropertyValue> implements PropertyValueService {

	@Autowired
	ProductDao productDao;

	@Autowired
	PropertyDao propertyDao;
	
	@Autowired
	PropertyValueDao propertyValueDao;
	
	
	@Override
	public List<PropertyValue> list(Product product){
		return propertyValueDao.list(product);
	};
}
