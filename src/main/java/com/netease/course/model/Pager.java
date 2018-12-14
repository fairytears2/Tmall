package com.netease.course.model;

import java.util.List;

public class Pager<T> {
		private int pagesize;
		
		private int pageoffset;
		
		private long total;
		
		private List<T> rows;

		public int getPagesize() {
			return pagesize;
		}

		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}

		public int getPageoffset() {
			return pageoffset;
		}

		public void setPageoffset(int pageoffset) {
			this.pageoffset = pageoffset;
		}

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public List<T> getRows() {
			return rows;
		}

		public void setRows(List<T> rows) {
			this.rows = rows;
		}

		public Pager() {
			super();
		}

		@Override
		public String toString() {
			return "Pager [pagesize=" + pagesize + ", pageoffset=" + pageoffset + ", total=" + total + ", rows=" + rows
					+ "]";
		}
		
		
		
		
}
