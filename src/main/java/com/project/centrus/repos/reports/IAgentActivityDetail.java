package com.project.centrus.repos.reports;

import java.util.List;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.reports.ActivityReportDetail;
import com.project.centrus.util.CustomPage;

public interface IAgentActivityDetail extends JpaRepository<ActivityReportDetail, String> {
	 

	//@Procedure(procedureName="sp_REPORT_DETAILED_QUEUE",value = "exec sp_REPORT_DETAILED_QUEUE('2022-09-10','2022-09-29','0','-1')")
	//@Query(nativeQuery=true,value="exec sp_REPORT_DETAILED_QUEUE '2022-09-10','2022-09-29','0','-1' \n-- #pageable\n  ")
	//@Query(nativeQuery=true,value="exec sp_REPORT_DETAILED_QUEUE '2022-09-10','2022-09-29','0','-1' \n --#pageable#--\n ")
			//countQuery="exec sp_REPORT_DETAILED_QUEUE '2022-09-10','2022-09-29','0','-1'")
//							countQuery="    SELECT count(*)\r\n"
//									+ "   FROM [rpt_AGENT_QUEUE_ACTIVITY] AQA, AGENT A, QUEUE Q\r\n"
//									+ "   WHERE Q.QID = AQA.SERVED_QID \r\n"
//									+ "   AND A.AID = AQA.AID\r\n"
//									+ "   AND AQA.TIME BETWEEN '2022-09-10' AND '2022-09-29'\r\n"
//									+ "   AND ('0' = '0' OR AQA.SERVED_QID IN (SELECT * FROM GET_IDS('0')) )\r\n"
//									+ "   AND ('-1' = '-1' OR ('-1' = '-2' AND A.DELETION_ORDER != 0) OR('-1' = '0' AND A.DELETION_ORDER = 0) OR A.AID IN (select * from dbo.GET_IDS('-1')))\r\n"
//									+ "  ")
			 
	//@Procedure(procedureName="sp_REPORT_DETAILED_QUEUE '2022-09-10','2022-09-29','0','-1'")
	
	
	@Query(nativeQuery=true,value="exec sp_REPORT_DETAILED_QUEUE :startTime,:endTime,'0',:aid")
	public List<ActivityReportDetail> getDetailReport(@RequestParam String startTime,@RequestParam String endTime,@RequestParam Long aid);  
	
  

	
}
