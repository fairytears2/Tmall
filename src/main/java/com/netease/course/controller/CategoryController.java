package com.netease.course.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

import java.util.List;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;


import com.netease.course.model.Category;

import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;


import com.netease.course.service.CategoryService;
import com.netease.course.service.ProductImageService;
import com.netease.course.service.ProductService;
import com.netease.course.service.PropertyService;
import com.netease.course.uitls.ImageUtil;


@Controller
public class CategoryController {
	
	
    @Autowired
    CategoryService categoryService;
  
    @Autowired
    ProductService productService;
    
    @Autowired
    PropertyService propertyService;
    
    @Autowired
	ProductImageService productImageService;

    @RequestMapping(value={"/","","index"})
    public String index() {
    	return "index";
    }
   
   @CrossOrigin 
   @ResponseBody
   @RequestMapping(value="/getcategories") 
   public List<Category> list(Model model){
	   List<Category> categories = categoryService.getlist();
	   for (Category category : categories) {
		   	List<Product> products =   productService.getlist(category);
		   	if(!products.isEmpty()) {
		   		for (Product product : products) {
			   	   List<ProductImage>images=productImageService.list(product);
			   	   if(!images.isEmpty()){
			   		   for (ProductImage productImage : images) {
						if (productImage.getType().contains("single")) {
							product.setFirstProductimage(productImage);
							break;
						}
			   		   }
			   	   }
				}
		   	}
		   	category.setProducts(products);
	   }
	   return categories;
   }
    
   @CrossOrigin 
   @ResponseBody
   @RequestMapping(value="/getcategory") 
   public Category get(@RequestParam("id") Integer id) {
	   return categoryService.load(id);
   }
  
   
   @CrossOrigin
   @ResponseBody
   @RequestMapping(value="/test1")
   public String test(Category category,@RequestParam("image")MultipartFile mFile,HttpServletRequest req) throws IOException{
	  System.out.println(category);
	  categoryService.update(category);
	  String path = req.getSession().getServletContext().getRealPath("/img/category");
	  File file = new File(path,"999.jpg");
	  if(!file.exists()) file.mkdirs();
	  try {
		mFile.transferTo(file);
	  } catch (IllegalStateException | IOException e) {
		e.printStackTrace();
	  }
	  BufferedImage img = ImageUtil.change2jpg(file);
	  ImageIO.write(img, "jpg", file);  
	  return "ok";
   }
   
   
   @CrossOrigin
   @ResponseBody
   @RequestMapping(value="/addcategory")
   public String addCategory(Category category,@RequestParam("image")MultipartFile mFile,HttpServletRequest req) throws IOException {
	   category.setId(null);
	   categoryService.add(category);
	   String path = req.getSession().getServletContext().getRealPath("/img/category");
		  File file = new File(path,category.getId()+".jpg");
		  if(!file.exists()) file.mkdirs();
		  try {
			mFile.transferTo(file);
		  } catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		  }
		  BufferedImage img = ImageUtil.change2jpg(file);
		  ImageIO.write(img, "jpg", file);  
       
       return "ok";
   }

   @CrossOrigin
   @ResponseBody
   @RequestMapping(value="/deletecategory")
   public String delete(@RequestParam("id")int id,HttpSession session) throws IOException {
       categoryService.delete(id);
       File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
       File file = new File(imageFolder,id+".jpg");
       file.delete();
       return "ok";
   }
   
   
   @CrossOrigin
   @ResponseBody
   @RequestMapping(value="/updatecategory")
   public String updateCategory(Category category,@RequestParam(value="img",required=false)MultipartFile mFile,HttpServletRequest req) throws IOException {
	  System.out.println(category);
	  categoryService.update(category);
	  System.out.println(mFile);
	   if(mFile != null) {
		   String path = req.getSession().getServletContext().getRealPath("/img/category");
			  File file = new File(path,category.getId()+".jpg");
			  if(!file.exists()) file.mkdirs();
			  try {
				mFile.transferTo(file);
			  } catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			  }
			  BufferedImage img = ImageUtil.change2jpg(file);
			  ImageIO.write(img, "jpg", file); 
	   }
	      
	   return "ok";
   }
   
}