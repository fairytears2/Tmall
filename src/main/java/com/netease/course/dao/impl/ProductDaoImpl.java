package com.netease.course.dao.impl;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.netease.course.dao.ProductDao;
import com.netease.course.model.Category;
import com.netease.course.model.Product;


@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public List<Product> getlist(Category category) {
		String jpql = "select new Product(p.id, p.name, p.subTitle, p.orignalPrice,p.promotePrice,p.stock,p.createDate, p.category, p.reviewCount,p.saleCount) from Product p where p.category = ?" ;
		return super.list(jpql,new Object[]{category},null);
	}

	@Override
	public List<Product> getlist() {
		String jpql = "from Product";
		return super.list(jpql, null, null);
	}

}
