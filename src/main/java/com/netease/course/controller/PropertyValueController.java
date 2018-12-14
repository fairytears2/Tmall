package com.netease.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.netease.course.model.Product;
import com.netease.course.model.Property;
import com.netease.course.model.PropertyValue;
import com.netease.course.service.ProductService;
import com.netease.course.service.PropertyService;
import com.netease.course.service.PropertyValueService;

@Controller
public class PropertyValueController {

	@Autowired
	ProductService productService;
	
	@Autowired
	PropertyService propertyService;
	@Autowired
	PropertyValueService propertyValueService;
	
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/getPropertyValue")
	public List<PropertyValue> listvalue(@RequestParam("id") Integer id){
		Product product = productService.load(id);
		System.out.println(product);
		List<Property> properties = propertyService.listname(product);
		List<PropertyValue> propertyValues = propertyValueService.list(product);
		List<Integer> ids = new ArrayList<>();
		for (PropertyValue Value : propertyValues) {
			ids.add(Value.getProperty().getId());
		}
		for (Property property : properties) {
			PropertyValue propertyValue = new PropertyValue();
			if(!ids.contains(property.getId())) {
				propertyValue.setProperty(property);
				propertyValues.add(propertyValue);
			}
		}
		return propertyValues;
	}
	
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/updatePropertyValue")
	public String updateValue(@RequestBody PropertyValue propertyValue) {
		if(propertyValue.getValue()!= null) {
			propertyValueService.update(propertyValue);
		}else {
			propertyValueService.delete(propertyValue.getId());
		}
		return "ok";
	}
	
	
}
