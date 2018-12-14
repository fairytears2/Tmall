package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;

public interface ProductImageDao extends BaseDao<ProductImage> {

	List<ProductImage> getlist(Product product);

}
