package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.CategoryDao;
import com.netease.course.dao.GeneralDao;
import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	GeneralDao<Category> generalDao;
	
	public List<Category> getlist(){
		return categoryDao.getlist();
	}

	@Override
	public int getTotal() {
		Category category = new Category();
		return generalDao.getTotal(category);
	}

	@Override
	public Pager<Category> getPager() {
		Category category = new Category();
		return generalDao.getPager(category);
	}
	
	
}
