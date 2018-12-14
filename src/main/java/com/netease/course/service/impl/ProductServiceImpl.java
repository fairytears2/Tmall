package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.GeneralDao;
import com.netease.course.dao.ProductDao;
import com.netease.course.model.Category;
import com.netease.course.model.Pager;
import com.netease.course.model.Product;
import com.netease.course.service.ProductService;


@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	
	@Autowired
	GeneralDao<Product> generalDao;
	
	@Autowired
	ProductDao productDao;
	
	
	@Override
	public int getTotal() {
		Product product = new Product();
		return generalDao.getTotal(product);
	}

	@Override
	public List<Product> getlist(Category category) {
		if (category != null) {
			return productDao.getlist(category);
		}else {
			return productDao.getlist();
		}
		
	}

	@Override
	public Pager<Product> getPager() {
		Product product = new Product();
		return generalDao.getPager(product);
	}

}
