package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.ActivityReportEfficiency;

public interface IActivityReportEfficiency extends JpaRepository<ActivityReportEfficiency, String> {
	
	@Query(nativeQuery=true,value="exec sp_REPORT_AGENT_ACTIVITY_EFFICIENCY :startTime,:endTime,:aid")
	public List<ActivityReportEfficiency> getEffiencyDetail(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid);
	

}
