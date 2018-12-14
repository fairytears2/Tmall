package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.GeneralDao;
import com.netease.course.dao.ProductDao;
import com.netease.course.dao.PropertyDao;
import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.model.Product;
import com.netease.course.model.Property;
import com.netease.course.service.PropertyService;
@Service("propertyService")
public class PropertyServiceImpl  extends BaseServiceImpl<Property> implements PropertyService{

	@Autowired
	GeneralDao<Property> generalDao;
	
	@Autowired
	ProductDao productDao;
	
	
	@Autowired
	PropertyDao propertyDao;
	
	@Override
	public int getTotal() {
		Property property = new Property();
		return generalDao.getTotal(property);
	}

	@Override
	public List<Property> getlist(Integer id) {
		if (id == null) {
			return propertyDao.getlist();
		}else{	
			Category category = new Category();
			category.setId(id);
			return propertyDao.getlist(category);
		}
		
	}

	@Override
	public Pager<Property> getPager() {
		Property property = new Property();
		return generalDao.getPager(property);
	}

	@Override
	public List<Property> listname(Product product) {
		System.out.println(product);
		Category category = product.getCategory();
		List<Property> properties= propertyDao.getlist(category);
		System.out.println(properties);
		return properties;
	}

}
