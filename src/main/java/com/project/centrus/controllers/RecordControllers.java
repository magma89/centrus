package com.project.centrus.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.Records;
import com.project.centrus.services.RecordServices;
 
@CrossOrigin
@RestController
@RequestMapping("/record")
public class RecordControllers {
	
	private RecordServices recordServices;

	public RecordControllers(RecordServices recordServices) { 
		this.recordServices = recordServices;
	}
	
	@GetMapping
	public Page<Records> getCurrentRecord(Pageable pageable){
		return recordServices.getCurrentRecord(pageable);
	}
	
	
//	@GetMapping("/filter/{agentname}/{starttime}/{queuename}/{duration}/{msisdn}")
//	public Page<Records> getFilteredRecords(@PathVariable("agentname") String agentname,@PathVariable("starttime") String starttime,@PathVariable("queuename") String queuename,
//											@PathVariable("duration") String duration,@PathVariable("msisdn") String msisdn, Pageable pageable){
//		return recordServices.getFilteredRecord(agentname,starttime,queuename,duration,msisdn,pageable);
//		
//	}
	
	@GetMapping("/filter")
	public Page<Records> getFilteredRecords(@RequestParam String startTime,@RequestParam String endTime,@RequestParam String operator,@RequestParam String queue,@RequestParam String msisdn,
											@RequestParam String durationInSec,@RequestParam int durationParam,@RequestParam String durationType, Pageable pageable){
		return recordServices.getFilteredRecord(startTime, endTime, operator,queue, msisdn,durationInSec,durationParam,durationType, pageable);
	}

}
