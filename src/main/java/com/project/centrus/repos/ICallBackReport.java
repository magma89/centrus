package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.CallBackReport;

public interface ICallBackReport extends JpaRepository<CallBackReport, String> {
	
	@Query(nativeQuery=true,value="exec sp_REPORT_CALL_BACK :startTime,:endTime,:qid")
	List<CallBackReport> getCallBackReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long qid);

}
