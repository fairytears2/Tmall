package com.netease.course.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.netease.course.model.Product;
import com.netease.course.model.ProductImage;
import com.netease.course.service.ProductImageService;
import com.netease.course.service.ProductService;
import com.netease.course.uitls.ImageUtil;

@Controller
public class ProductImageController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductImageService productImageService;
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/getImage")
	public Product listSingle(@RequestParam("id") Integer id){
		Product product= productService.load(id);
		List<ProductImage> images = productImageService.list(product);	
		List<ProductImage> singleImages = new ArrayList<>();
		List<ProductImage> detailImages = new ArrayList<>();
		for (ProductImage productImage : images) {
			System.out.println(productImage);
			if(productImage.getType().contains("single")) {
				singleImages.add(productImage);
			}else if(productImage.getType().contains("detail")){
				detailImages.add(productImage);
			}
		}
		product.setProductSingleImage(singleImages);
		product.setProductDetailImage(detailImages);
		return product;
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/addimage")
	public String test( Integer productId,Integer type , @RequestParam(value="image",required=false)MultipartFile mFile,HttpServletRequest req) throws IOException{
		Product product = productService.load(productId);
		ProductImage productImage = new ProductImage();
		String path = "/" ;
		if (type==1) {
			  	productImage.setType("type_single");
				path = req.getSession().getServletContext().getRealPath("/img/productSingle");
		}else{
			  	productImage.setType("type_detail");
			  	path = req.getSession().getServletContext().getRealPath("/img/productDetail");
		}
		productImage.setProduct(product);
		productImageService.add(productImage);
		  if(mFile!=null) {
			  File file = new File(path,productImage.getId()+".jpg");
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
	
		@CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/deleteimage")
	   public String deleteS(@RequestParam("id")int id,HttpSession session) throws IOException {
	       productImageService.delete(id);
	       File  imageFolder1= new File(session.getServletContext().getRealPath("img/productSingle"));
	       File  imageFolder2= new File(session.getServletContext().getRealPath("img/productDetail"));
	       File file1 = new File(imageFolder1,id+".jpg");
	       File file2 = new File(imageFolder2,id+".jpg");
	       file1.delete();
	       file2.delete();
	       return "ok";
	   }
	
		
		
	
}
