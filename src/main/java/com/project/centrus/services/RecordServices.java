package com.project.centrus.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.Records;
import com.project.centrus.repos.IRecordRepository;
import com.project.centrus.util.DateFormatter;
import com.project.centrus.util.LocalTimeFormatter;

import lombok.extern.slf4j.Slf4j;

 
 
@Service
@Slf4j
public class RecordServices {
	
	IRecordRepository iRecordRepository;
	LocalTimeFormatter timeFormatter;
	DateFormatter dateFormatter;
	
	public RecordServices(IRecordRepository iRecordRepository,LocalTimeFormatter timeFormatter,DateFormatter dateFormatter) { 
		this.iRecordRepository = iRecordRepository;
		this.timeFormatter = timeFormatter;
		this.dateFormatter = dateFormatter;
	}

	public Page<Records> getCurrentRecord(Pageable pageable){
		List<Records> data = iRecordRepository.getCurrentRecord();
		
		for(Records temp : data) {
			temp.setStartTime(dateFormatter.getDateTimeFormat(temp.getStartTime()));
			temp.setEndTime(dateFormatter.getDateTimeFormat(temp.getEndTime()));
			temp.setDurationInSeconds(timeFormatter.getConverter(temp.getDurationInSeconds(), 1));
		}
		
				
		final int start = (int)pageable.getOffset();
		final int end 	= Math.min((start + pageable.getPageSize()),data.size());
		final Page<Records> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
		
		return page;
		
	}
	
//	@SuppressWarnings("unchecked")
//	public Page<Records> getFilteredRecord(@PathVariable String agentname,@PathVariable String starttime,@PathVariable String queuename,
//			@PathVariable String duration,@PathVariable String msisdn, Pageable pageable){
//		
//		@SuppressWarnings("unchecked")
//		List<Records> data = (List<Records>) getFilteredRecord(agentname,starttime,queuename,duration,msisdn,pageable);
//		for(Records temp : data) {
//			temp.setStartTime(dateFormatter.getDateTimeFormat(temp.getStartTime()));
//			temp.setDurationInSeconds(timeFormatter.getConverter(temp.getDurationInSeconds(), 1)); 
//		}
//		
//		return (Page<Records>) data;
//		
//		
//		//return iRecordRepository.getFilteredRecord(agentname,starttime,queuename,duration,msisdn,pageable);
//	}
	
	public Page<Records> getFilteredRecord(@RequestParam String startTime,@RequestParam String endTime,@RequestParam String operator,@RequestParam String queue,@RequestParam String msisdn,
			@RequestParam String durationInSec,@RequestParam int durationParam,@RequestParam String durationType, Pageable pageable){
		List<Records> data = iRecordRepository.getFilteredRecord(startTime, endTime, operator, queue, msisdn, durationInSec, durationParam, durationType);
		for(Records temp : data) {
			temp.setStartTime(dateFormatter.getDateTimeFormat(temp.getStartTime()));
			temp.setEndTime(dateFormatter.getDateTimeFormat(temp.getEndTime()));
			temp.setDurationInSeconds(timeFormatter.getConverter(temp.getDurationInSeconds(), 1));
		}
		
		final int start = (int)pageable.getOffset();
		final int end 	= Math.min((start + pageable.getPageSize()),data.size());
		final Page<Records> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
		
		return page;
	}

}
