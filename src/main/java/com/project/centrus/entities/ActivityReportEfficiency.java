package com.project.centrus.entities;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import lombok.Data;

@Entity
@Data
public class ActivityReportEfficiency {
	
	 @Id
	 @Column(name="TIME")
	 String time;
	 
	 @Column(name="AGENT_NAME")
	 String agentName;
	 
	 @Column(name="SHIFT_HOURS")
	 String shiftHours;
	 
	 @Column(name="LOGIN_TIME")
	 String loginTime;
	 
	 @Column(name="LOGOUT_TIME")
	 String logoutTime;
	 
	 @Column(name="INCOMING_CALL_COUNT")
	 Integer incomingCallCount;
	 
	 @Column(name="OUTGOING_CALL_COUNT")
	 Integer outgoingCallCount;
	 
	 @Column(name="TOTAL_CALL_COUNT")
	 Integer totalCallCount;
	 
	 @Column(name="TOTAL_INCOMING_RING_DURATION")
	 String totalIncomingRingDuration;
	 
	 @Column(name="AVERAGE_INCOMING_RING_DURATION")
	 String averageIncomingRingDuration;
	 
	 @Column(name="TOTAL_OUTGOING_RING_DURATION")
	 String totalOutgoingRingDuration;
	 
	 @Column(name="TOTAL_HOLD_DURATION")
	 String totalHoldDuration;
	 
	 @Column(name="AVERAGE_TALK_DURATION")
	 String averageTalkDuration;
	 
	 @Column(name="YEMEK")
	 String yemek;
	 
	 @Column(name="TOPLANTI")
	 String toplanti;
	 
	 @Column(name="MUS_ISLEMLERI_ACW")
	 String musIslemleriAcw;
	 
	 @Column(name="DIS_ARAMA")
	 String disArama;
	 
	 @Column(name="MOLADA_GIRIS")
	 String moladaGiris;
	 
	 @Column(name="PROBLEM_TAKIP")
	 String problemTakip;
	 
	 @Column(name="DIGITAL_KANALLAR")
	 String digitalKanallar;
	 
	 @Column(name="TOTAL_BREAK_TIME")
	 String totalBreakTime;
	 
	 @Column(name="DURATION_INCOMING_CALL")
	 String durationIncomingCall;
	 
	 @Column(name="DURATION_OUTGOING_CALL")
	 String durationOutgoingCall;
	 
	 @Column(name="TOTAL_TALK_DURATION")
	 String totalTalkDuration;
	 
	 @Column(name="WORK_DURATION")
	 String workDuration;
	 
	 @Column(name="RAW_WORK_DURATION")
	 String rawWorkDuration;
	 
	 @Column(name="WORK_DURATION_DEVIATION")
	 String workDurationDeviation;
	 
	 @Column(name="WORK_DURATION_WITHOUT_LUNCH")
	 String workDurationWithoutLunch;
	 
	 @Column(name="EFFICIENCY")
	 String effiency;
	 
	 @Column(name="LOSS_TIME")
	 String lossTime;
	  
	 

}
