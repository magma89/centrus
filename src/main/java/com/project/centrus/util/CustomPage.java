package com.project.centrus.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
 

@Component
public class CustomPage {
	
	public Page<Object> customPage(Object toData,Pageable pageable){
	
	@SuppressWarnings("unchecked")
	List<Object> data = (List<Object>) toData;
	
	final int start = (int)pageable.getOffset();
	final int end = Math.min((start + pageable.getPageSize()), data.size()); 
	final Page<Object> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
   
	return page;

	}
}
