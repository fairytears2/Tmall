package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.CategoryDao;
import com.netease.course.model.Category;
import com.netease.course.model.Pager;
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	public int getTotal() {
		String jpql = "select count(*) from Category";
		return (int) super.queryByjpql(jpql, null, null);
	}

	public List<Category> getlist(){
		String jpql = "select new Category(c.id,c.name) from Category c order by c.id desc";
		return list(jpql, null, null);		
	}
	
	public Pager<Category> getPager(){
		String jpql = "from Category";
		return find(jpql, null, null);
	}
	
}
