package com.netease.course.dao;

import java.util.List;

import com.netease.course.model.Order;
import com.netease.course.model.Pager;

public interface OrderDao extends BaseDao<Order>{
	
	public int getTotal();
	
	public List<Order> getlist();
	
	public Pager<Order> getPager();
}
