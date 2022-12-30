package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.ActivityReportSummary;

public interface IActivityReportSummary extends JpaRepository<ActivityReportSummary, String> {
	
	@Query(nativeQuery=true,value="exec sp_REPORT_AGENT_ACTIVITY_SUMMARY_V2 :startTime,:endTime,:aid")
	public List<ActivityReportSummary> getReportSummary(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid);

}
