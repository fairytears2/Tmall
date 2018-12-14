package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.PropertyValueDao;
import com.netease.course.model.Product;
import com.netease.course.model.PropertyValue;


@Repository("PropertyValueDao")
public class PropertyValueDaoImpl extends BaseDaoImpl<PropertyValue> implements PropertyValueDao{

	@Override
	public List<PropertyValue> list(Product product) {
		String jpql = "from PropertyValue p where p.product = ?";
		return super.list(jpql, new Object[]{product},null);
	}

}
