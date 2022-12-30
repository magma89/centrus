package com.project.centrus.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class CustomPage<T> {

		private List<T> content;
		private int pageNumber;
		private int pageSize;
		private Sort sort;
		private int totalPages;
		private long totalElements;
		
		public CustomPage(Page page,List<T> list) {
			this.content = list;
			this.pageNumber = page.getNumber();
			this.pageSize = page.getNumber();
			this.pageSize = page.getSize();
			this.totalPages = page.getTotalPages();
			this.totalElements = page.getTotalElements();
			this.sort = page.getSort();
		}
}
