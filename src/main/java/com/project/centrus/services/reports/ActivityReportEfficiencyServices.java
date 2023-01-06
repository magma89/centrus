package com.project.centrus.services.reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.reports.ActivityReportEfficiency;
import com.project.centrus.repos.reports.IActivityReportEfficiency;
import com.project.centrus.util.LocalTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivityReportEfficiencyServices {
	
	IActivityReportEfficiency activityReportEfficiency;
	LocalTimeFormatter timeFormatter;

	public ActivityReportEfficiencyServices(IActivityReportEfficiency activityReportEfficiency,LocalTimeFormatter timeFormatter) { 
		this.activityReportEfficiency = activityReportEfficiency;
		this.timeFormatter = timeFormatter;
	}

	
	public Page<ActivityReportEfficiency> getDetailEffiency(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid,Pageable pageable){
		List<ActivityReportEfficiency> data = activityReportEfficiency.getEffiencyDetail(startTime,endTime,aid); 
		
		for (ActivityReportEfficiency temp : data) { 
 	
			temp.setTotalIncomingRingDuration(timeFormatter.getConverter(temp.getTotalIncomingRingDuration(), 0));
			temp.setAverageIncomingRingDuration(timeFormatter.getConverter(temp.getAverageIncomingRingDuration(), 0));
			temp.setTotalOutgoingRingDuration(timeFormatter.getConverter(temp.getTotalOutgoingRingDuration(), 0));
			temp.setTotalHoldDuration(timeFormatter.getConverter(temp.getTotalHoldDuration(), 0));
			temp.setAverageTalkDuration(timeFormatter.getConverter(temp.getAverageTalkDuration(), 0));
			temp.setYemek(timeFormatter.getConverter(temp.getYemek(), 0));
			temp.setMusIslemleriAcw(timeFormatter.getConverter(temp.getMusIslemleriAcw(), 0));
			temp.setToplanti(timeFormatter.getConverter(temp.getToplanti(), 0));
			temp.setDisArama(timeFormatter.getConverter(temp.getDisArama(), 0));
			temp.setMoladaGiris(timeFormatter.getConverter(temp.getMoladaGiris(), 0));
			temp.setProblemTakip(timeFormatter.getConverter(temp.getProblemTakip(), 0));
			temp.setDigitalKanallar(timeFormatter.getConverter(temp.getDigitalKanallar(), 0));
			temp.setTotalBreakTime(timeFormatter.getConverter(temp.getTotalBreakTime(), 0));
			temp.setDurationIncomingCall(timeFormatter.getConverter(temp.getDurationIncomingCall(), 0));
			temp.setDurationOutgoingCall(timeFormatter.getConverter(temp.getDurationOutgoingCall(), 0));
			temp.setTotalTalkDuration(timeFormatter.getConverter(temp.getTotalTalkDuration(), 0));
			temp.setWorkDuration(timeFormatter.getConverter(temp.getWorkDuration(), 1));
			temp.setRawWorkDuration(timeFormatter.getConverter(temp.getRawWorkDuration(), 1));
			temp.setWorkDurationDeviation(timeFormatter.getConverter(temp.getWorkDurationDeviation(), 2));
			temp.setWorkDurationWithoutLunch(timeFormatter.getConverter(temp.getWorkDurationWithoutLunch(), 1));
			temp.setEffiency(timeFormatter.getConverter(temp.getEffiency(), 2));
			temp.setLossTime(timeFormatter.getConverter(temp.getLossTime(), 2));
			
			 
		}
		
//		DateFormat obj = new SimpleDateFormat(" HH:mm:ss");
//		System.out.println(obj.format(1000000));
//		Instant dateTime = Instant.ofEpochMilli(1000000);
//		System.out.println("= = = = = = = = ");
//		System.out.println(dateTime);
//		System.out.println("= = = = = = = = ");
//		LocalTime localTime = LocalTime.ofNanoOfDay(1000000); 
//		System.out.println(localTime);
//		System.out.println("= = = = = = = = "); 
//		LocalDateTime localDateTime = LocalDateTime.ofInstant(dateTime, ZoneId.systemDefault());
//		System.out.println(localDateTime);
		final int start = (int)pageable.getOffset(); 
		final int end 	= Math.min((start + pageable.getPageSize()),data.size());
		log.info("Page Size :" + pageable.getPageSize());
		log.info("Start : " + start);
		log.info("End : " + end);
		log.info("Data Size : " + data.size());  
		final Page<ActivityReportEfficiency> page = new PageImpl<>(data.subList(start, end),pageable,data.size());
	 
		 
 
		 
		return page;
		 
	}
}
