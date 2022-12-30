package com.project.centrus.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.CallBackReport;
import com.project.centrus.repos.ICallBackReport;

@Service
public class CallBackReportServices {

	ICallBackReport callBackReport;

	public CallBackReportServices(ICallBackReport callBackReport) { 
		this.callBackReport = callBackReport;
	}
	
	public Page<CallBackReport> getCallBackReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long qid,Pageable pageable){
		List<CallBackReport> data = callBackReport.getCallBackReport(startTime,endTime,qid);
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), data.size());
		final Page<CallBackReport> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
		return page;
	}
	
	
}
