package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.ProductImageDao;
import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;


@Repository("productImageDao")
public class ProductImageDaoImpl extends BaseDaoImpl<ProductImage> implements ProductImageDao{

	@Override
	public List<ProductImage> getlist(Product product) {
		String jpql = "from ProductImage p where  p.product = ?";
		return super.list(jpql, new Object[]{product}, null);
	}



}
