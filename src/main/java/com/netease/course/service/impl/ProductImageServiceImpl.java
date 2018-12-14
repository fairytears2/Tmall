package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.netease.course.dao.ProductImageDao;
import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;
import com.netease.course.service.ProductImageService;

@Service("productImageService")
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage> implements ProductImageService {

	
	@Autowired
	ProductImageDao productImageDao;
	
	
	@Override
	public List<ProductImage> list(Product product) {
		return productImageDao.getlist(product);
	}

}
