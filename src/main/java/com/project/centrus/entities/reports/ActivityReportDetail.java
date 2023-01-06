package com.project.centrus.entities.reports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Data;

@Entity
@Data  
//@NamedStoredProcedureQueries({
//	@NamedStoredProcedureQuery(name="Activity_Report_Detail", procedureName="sp_REPORT_DETAILED_QUEUE",parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.IN, name="@STARTDATE", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name="@ENDDATE", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name="@QID", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name="@AID", type = String.class)
//			
//	})
//	
//})


public class ActivityReportDetail {
		
		@Id 
		@Column(name="TIME")
		String time;
		
		@Column(name="SERVED_QID")
		String servedQid;
		
		@Column(name="QUEUE_NAME")
		String queueName;
		
		@Column(name="AGENT_NAME")
		String agentName;
		
		@Column(name="AGENT_STATUS")
		String agentStatus;
		
		@Column(name="HOUR_DURATION_IN_STATUS")
		String hourDurationInStatus;
		
		@Column(name="MIN_DURATION_IN_STATUS")
		String minDurationInStatus;
		
		@Column(name="SEC_DURATION_IN_STATUS")
		String secDurationInStatus;
}
