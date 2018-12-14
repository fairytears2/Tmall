package com.netease.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.course.dao.OrderDao;
import com.netease.course.model.Order;
import com.netease.course.model.Pager;
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{
	@Override
	public int getTotal() {
		String jpql = "select count(*) from Order";
		return (int) super.queryByjpql(jpql, null, null);
	}

	public List<Order> getlist(){
		String jpql = "from Order";
		return list(jpql, null, null);		
	}
	
	public Pager<Order> getPager(){
		String jpql = "from Order";
		return find(jpql, null, null);
	}
}
