package com.project.centrus.controllers.reports;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.reports.ActivityReportDetail;
import com.project.centrus.entities.reports.ActivityReportEfficiency;
import com.project.centrus.entities.reports.ActivityReportSummary;
import com.project.centrus.services.reports.ActivityReportEfficiencyServices;
import com.project.centrus.services.reports.ActivityReportSummaryServices;
import com.project.centrus.services.reports.AgentActivityDetailServices;
import com.project.centrus.util.CustomPage;

@CrossOrigin
@RestController
@RequestMapping("/activity")
public class AgentActivityControllers {
	
	private AgentActivityDetailServices agentActivityDetailServices;
	private ActivityReportEfficiencyServices activityReportEffiencyServices;
	private ActivityReportSummaryServices activityReportSummaryServices;

	public AgentActivityControllers(AgentActivityDetailServices agentActivityDetailServices,ActivityReportEfficiencyServices activityReportEffiencyServices,ActivityReportSummaryServices activityReportSummaryServices) { 
		this.agentActivityDetailServices = agentActivityDetailServices;
		this.activityReportEffiencyServices = activityReportEffiencyServices;
		this.activityReportSummaryServices = activityReportSummaryServices;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/detail")
	public Page<Object> getDetailReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable){
		System.out.println(pageable.getOffset() + "offset");
		System.out.println(pageable.getPageNumber() + "pageNumber");
		System.out.println(pageable.getPageSize() + "pageSize");
		
		return agentActivityDetailServices.getDetailReport(startTime,endTime,aid,pageable);
		
		
//		List<ActivityReportDetail> list = (List<ActivityReportDetail>) agentActivityDetailServices.getDetailReport(pageable);
//		Page<ActivityReportDetail> pages = new PageImpl<ActivityReportDetail>(list, pageable, list.size());
//		return (List<ActivityReportDetail>) pages;
	}
	
	@GetMapping("/effiency")
	public Page<ActivityReportEfficiency> getReportEffiency(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable){
		return activityReportEffiencyServices.getDetailEffiency(startTime,endTime,aid,pageable);
	}
	
	@GetMapping("/summary")
	public Page<ActivityReportSummary> getReportSummary(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable){
		return activityReportSummaryServices.getActivityReportSummary(startTime,endTime,aid,pageable);
	}
 

}
