package com.project.centrus.services.reports;

 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.reports.ActivityReportSummary;
import com.project.centrus.repos.reports.IActivityReportSummary;
import com.project.centrus.util.DateFormatter;
import com.project.centrus.util.LocalTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivityReportSummaryServices { 
	
	IActivityReportSummary activityReportSummary;
	LocalTimeFormatter timeFormatter;
	DateFormatter dateFormatter;
	
	public ActivityReportSummaryServices(IActivityReportSummary activityReportSummary,LocalTimeFormatter timeFormatter,DateFormatter dateFormatter) { 
		this.activityReportSummary = activityReportSummary;
		this.timeFormatter = timeFormatter;
		this.dateFormatter = dateFormatter;
	}

	public Page<ActivityReportSummary> getActivityReportSummary(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable) {
		List<ActivityReportSummary> data = activityReportSummary.getReportSummary(startTime,endTime,aid);
		
		for(ActivityReportSummary temp : data) {
			temp.setDurationIncomingCall(timeFormatter.getConverter(temp.getDurationIncomingCall(), 0));
			temp.setDurationOutgoingCall(timeFormatter.getConverter(temp.getDurationOutgoingCall(), 0));
			temp.setTotalTalkDuration(timeFormatter.getConverter(temp.getTotalTalkDuration(), 0));
			temp.setAverageIncomingTalkDuration(timeFormatter.getConverter(temp.getAverageIncomingTalkDuration(), 0));
			temp.setYemek(timeFormatter.getConverter(temp.getYemek(), 0));
			temp.setMusIslemleriAcw(timeFormatter.getConverter(temp.getMusIslemleriAcw(), 0)); 
			temp.setToplanti(timeFormatter.getConverter(temp.getToplanti(), 0));
			temp.setDisArama(timeFormatter.getConverter(temp.getDisArama(), 0));
			temp.setMoladaGiris(timeFormatter.getConverter(temp.getMoladaGiris(), 0));
			temp.setProblemTakip(timeFormatter.getConverter(temp.getProblemTakip(), 0));
			temp.setDigitalKanallar(timeFormatter.getConverter(temp.getDigitalKanallar(), 0));
			temp.setAverageOutgoingTalkDuration(timeFormatter.getConverter(temp.getAverageOutgoingTalkDuration(), 0));
			temp.setAverageTalkDuration(timeFormatter.getConverter(temp.getAverageTalkDuration(), 0));
			temp.setTotalFreeDuration(timeFormatter.getConverter(temp.getTotalFreeDuration(), 1)); 
			temp.setTotalIncomingWrapup(timeFormatter.getConverter(temp.getTotalIncomingWrapup(), 0));
			temp.setTotalOutgoingWrapup(timeFormatter.getConverter(temp.getTotalOutgoingWrapup(), 0));
			temp.setTotalIncomingRingDuration(timeFormatter.getConverter(temp.getTotalIncomingRingDuration(), 0));
			temp.setTotalOutgoingRingDuration(timeFormatter.getConverter(temp.getTotalOutgoingRingDuration(), 0));
			temp.setTotalHoldDuration(timeFormatter.getConverter(temp.getTotalHoldDuration(), 0));
			temp.setWorkDuration(timeFormatter.getConverter(temp.getWorkDuration(), 1));
			temp.setLoginTime(dateFormatter.getDateTimeFormat(temp.getLoginTime()));
			temp.setLogoutTime(dateFormatter.getDateTimeFormat(temp.getLogoutTime()));
			temp.setFirstCallTime(dateFormatter.getDateTimeFormat(temp.getFirstCallTime()));
			temp.setLastCallTime(dateFormatter.getDateTimeFormat(temp.getLastCallTime()));
 
			
		}
		
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), data.size());
		final Page<ActivityReportSummary> page = new PageImpl<>(data.subList(start, end), pageable, data.size());
		return page;
	}

}
