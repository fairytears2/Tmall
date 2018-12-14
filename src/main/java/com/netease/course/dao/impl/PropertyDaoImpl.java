package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.PropertyDao;
import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.model.Property;


@Repository("propertyDao")
public class PropertyDaoImpl extends BaseDaoImpl<Property> implements PropertyDao {

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Property> getlist() {
		String jpql = "from Property";
		return super.list(jpql, null, null);
	}

	@Override
	public Pager<Property> getPager() {
		return null;
	}

	@Override
	public List<Property> getlist(Category category) {
		String jpql = "from Property p where p.category = ?";
		return super.list(jpql, new Object[] {category}, null);
	}

}
