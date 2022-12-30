package com.project.centrus.controllers;

 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.CallBackReport;
import com.project.centrus.services.CallBackReportServices;

@CrossOrigin
@RestController
@RequestMapping("/callback")
public class CallBackReportControllers {

	 
	private CallBackReportServices callBackReportServices;

	public CallBackReportControllers(CallBackReportServices callBackReportServices) { 
		this.callBackReportServices = callBackReportServices;
	}
	
	@GetMapping
	public Page<CallBackReport> getCallBackReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long qid,Pageable pageable){
		return callBackReportServices.getCallBackReport(startTime,endTime,qid,pageable);
	}
 
	
	
}
