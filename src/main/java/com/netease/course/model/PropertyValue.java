package com.netease.course.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="sb_property_value")
@BatchSize(size=20)
public class PropertyValue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="ptid")
	private Property property;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;

	
	private String value;
	
	
	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Property getProperty() {
		return property;
	}


	public void setProperty(Property property) {
		this.property = property;
	}

	
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "PropertyValue [id=" + id + ", property=" + property + ", product=" + product +",value="+value+ "]";
	}


	public PropertyValue() {
		super();
	}
	

	
	
}
