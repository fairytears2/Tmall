package com.netease.course.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="sb_product")
@BatchSize(size=20)
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String subTitle;
	
	private float orignalPrice;
	
	
	private float promotePrice;
	
	private int stock;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cid")
	private Category category;
	
    
    @Transient
	private ProductImage firstProductimage;
    @Transient
	private List<ProductImage> productImages;
    @Transient
	private List<ProductImage> productSingleImage;
    @Transient
	private List<ProductImage> productDetailImage;
	
	private int reviewCount;

	private int saleCount;

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public float getOrignalPrice() {
		return orignalPrice;
	}

	public void setOrignalPrice(float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	public float getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductImage getFirstProductimage() {
		return firstProductimage;
	}

	public void setFirstProductimage(ProductImage firstProductimage) {
		this.firstProductimage = firstProductimage;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductImage> getProductSingleImage() {
		return productSingleImage;
	}

	public void setProductSingleImage(List<ProductImage> productSingleImage) {
		this.productSingleImage = productSingleImage;
	}

	public List<ProductImage> getProductDetailImage() {
		return productDetailImage;
	}

	public void setProductDetailImage(List<ProductImage> productDetailImage) {
		this.productDetailImage = productDetailImage;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public Product() {
		super();
	}

	
	
	public Product(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Product(int id, String name, String subTitle, float orignalPrice, float promotePrice, int stock,
			Date createDate, Category category, int reviewCount, int saleCount) {
		super();
		this.id = id;
		this.name = name;
		this.subTitle = subTitle;
		this.orignalPrice = orignalPrice;
		this.promotePrice = promotePrice;
		this.stock = stock;
		this.createDate = createDate;
		this.category = category;
		this.reviewCount = reviewCount;
		this.saleCount = saleCount;
	}

	@Override
	public String toString() {
		return "Product [id="+ id +",name=" + name + ", subTitle=" + subTitle + ", orignalPrice=" + orignalPrice + ", promotePrice="
				+ promotePrice + ", stock=" + stock + ", createDate=" + createDate + ", reviewCount=" + reviewCount
				+ ", saleCount=" + saleCount + "]";
	}
	
	
	
	
}
