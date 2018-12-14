package com.netease.course.model;



public class SystemContext {

	private static ThreadLocal<Integer> pageoffset = new ThreadLocal<>();
	
	private static ThreadLocal<Integer> pagesize = new ThreadLocal<>();
	
	private static ThreadLocal<String> sort = new ThreadLocal<>();
	
	private static ThreadLocal<String> method = new ThreadLocal<>();
		
	public static Integer getPageoffset() {
		return pageoffset.get();
	}

	public static void setPageoffset(Integer _pageoffset) {
		pageoffset.set(_pageoffset);
	}

	public static Integer getPagesize() {
		return pagesize.get();
	}

	public static void setPagesize(Integer _pagesize) {
		pagesize.set(_pagesize);;
	}

	public static String getSort() {
		return sort.get();
	}

	public static void setSort(String _sort) {
		sort.set(_sort);;
	}

	public static String getMethod() {
		return method.get();
	}

	public static void setMethod(String _method) {
		method.set(_method);;
	}

	public static void removePageSize() {
		pagesize.remove();
	}
	
	public static void removePageOffset() {
		pageoffset.remove();
	}
	
	public static void removeSort() {
		sort.remove();
	}

	public static void removeMethod() {
		method.remove();
	}
	
}
