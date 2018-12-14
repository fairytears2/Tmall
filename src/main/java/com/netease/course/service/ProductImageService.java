package com.netease.course.service;

import java.util.List;

import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;

public interface ProductImageService extends BaseService<ProductImage> {

	public List<ProductImage> list(Product product);
	
	
}
