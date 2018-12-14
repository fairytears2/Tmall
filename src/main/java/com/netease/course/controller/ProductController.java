package com.netease.course.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.netease.course.model.Category;
import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;

import com.netease.course.service.CategoryService;
import com.netease.course.service.ProductImageService;
import com.netease.course.service.ProductService;

@Controller
public class ProductController {
	 	@Autowired
		CategoryService categoryService;
	
	   @Autowired
	   ProductService productService;
	   
	   @Autowired
	   ProductImageService productImageService;
	    
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/getproducts")
	   public List<Product> productsList(@RequestParam(value="id",required=false) Integer id){
		   Category categoty = categoryService.load(id);
		   List<Product> products = new ArrayList<>();
		   if (categoty != null) {
			   products  = productService.getlist(categoty);
			   System.out.println(products);
			   if (!products.isEmpty()) {
				   for (Product product : products) {
						  List<ProductImage> images =  productImageService.list(product);
						  if (!images.isEmpty()) {	  
							  for (ProductImage productImage : images) {
								if (productImage.getType().contains("single")) {
									product.setFirstProductimage(productImage);
									break;
								}
							  }
						  }					 
				   }
			   } 
		   }
		   System.out.println(products);
		   return products;
	   }
	   
	   
	   
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/getproduct")
	   public Product getProduct(@RequestParam("id") Integer id) {
		   System.out.println(id);
		   Product product =  productService.load(id);
		   List<ProductImage> images =productImageService.list(product);
		   List<ProductImage> sImages = new ArrayList<>();
		   List<ProductImage> dImages = new ArrayList<>();
		   if (!images.isEmpty()) {
			   	int i = 0;
				for (ProductImage productImage : images) {
					if(productImage.getType().contains("single")) {
						if(i == 0 ) {
							product.setFirstProductimage(productImage);
							i++;
						}
						sImages.add(productImage);
					}else {
						dImages.add(productImage);
					}
				}
				product.setProductSingleImage(sImages);
				product.setProductDetailImage(dImages);
		   }
		   
		   return product;
		   
	   }
	   
	   
	   
	   
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/addProduct")
	   public String addProduct(@RequestBody Product product) {
		   System.out.println(product);
		   product.setCreateDate(new Date());
		   productService.add(product);
		   return "ok";
	   };
	   
	   
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/deleteProduct")
	   public String deleteProduct(@RequestParam("id") Integer id) {
		   productService.delete(id);   
		   return "ok";
	   }
	   
	   
	   
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/updateProduct")
	   public String updateProduct(@RequestBody Product product) throws IOException{
		 productService.update(product);
		  return "ok";
	   }
	   
	   
	   
	   
		
	   
	   
	   
}
