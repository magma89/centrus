package com.project.centrus.services.reports;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.reports.ActivityReportDetail;
import com.project.centrus.repos.reports.IAgentActivityDetail;
import com.project.centrus.util.CustomPage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AgentActivityDetailServices {

	IAgentActivityDetail agentActivtyDetail;
	CustomPage customPage;

	public AgentActivityDetailServices(IAgentActivityDetail agentActivtyDetail,CustomPage customPage) { 
		this.agentActivtyDetail = agentActivtyDetail;
		this.customPage = customPage;
	}
	
//	public Page<ActivityReportDetail> getDetailReport(Pageable pageable){
//		return agentActivtyDetail.getDetailReport(pageable);
//	}


public Page<Object> getDetailReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable) {
		
		System.out.println(pageable);
		List<ActivityReportDetail> data = agentActivtyDetail.getDetailReport(startTime,endTime,aid);
		
//		final int start = (int)pageable.getOffset();
//		final int end = Math.min((start + pageable.getPageSize()), data.size());
//		log.info("Page Size :" + pageable.getPageSize());
//		log.info("Start :" + start);
//		log.info("End :" + end);
//		log.info("Data Size : " + data.size());
//		
//		final Page<ActivityReportDetail> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
//	 
//
//		return page;
		
		Page<Object> page = customPage.customPage(data, pageable);
		return page;
	}

 

}
