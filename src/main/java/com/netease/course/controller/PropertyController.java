package com.netease.course.controller;


import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.netease.course.model.Property;
import com.netease.course.service.PropertyService;


@Controller
@RequestMapping("")
public class PropertyController {
	
	   @Autowired
	   PropertyService propertyService;
	   
	        
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/gerproperties")
	   public List<Property> propertyList(@RequestParam(value="id",required=false) Integer id){   
		   return propertyService.getlist(id);
	   }
	
	
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/addProperty")
	   public String addProduct(@RequestBody Property property) {
		   propertyService.add(property);
		   return "ok";
	   };
	   
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/deleteProperty")
	   public String deleteProduct(@RequestParam("id") Integer id) {
		   propertyService.delete(id);   
		   return "ok";
	   }
	   
	    
	   @CrossOrigin
	   @ResponseBody
	   @RequestMapping(value="/updateProperty")
	   public String test(@RequestBody Property property) throws IOException{
		  propertyService.update(property);
		  return "ok";
	   }
	   
	   
}
