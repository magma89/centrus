package com.project.centrus.entities.reports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ActivityReportSummary {
	
	@Id
	@Column(name="TIME")
	String time;
	
	@Column(name="AGENT_NAME")
	String agentName;
	
	@Column(name="COMING_SERVED_CALL")
	Integer comingServedCall;
	
	@Column(name="COMING_MISSED_CALL")
	Integer comingMissedCall;
	
	@Column(name="COMING_REFUSED_CALL")
	Integer comingRefusedCall;
	
	@Column(name="GOING_SERVED_CALL")
	Integer goindServedCall;
	
	@Column(name="TOTAL_CALL")
	Integer totalCall;
	
	@Column(name="DURATION_INCOMING_CALL")
	String durationIncomingCall;
	
	@Column(name="DURATION_OUTGOING_CALL")
	String durationOutgoingCall;
	
	@Column(name="TOTAL_TALK_DURATION")
	String totalTalkDuration;
	
	@Column(name="AVERAGE_INCOMING_TALK_DURATION")
	String averageIncomingTalkDuration;
	
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
	
	@Column(name="AVERAGE_OUTGOING_TALK_DURATION")
	String averageOutgoingTalkDuration;
	
	@Column(name="AVERAGE_TALK_DURATION")
	String averageTalkDuration;
	
	@Column(name="TOTAL_FREE_DURATION")
	String totalFreeDuration;
	
	@Column(name="TOTAL_INCOMING_WRAPUP")
	String totalIncomingWrapup;
	
	@Column(name="TOTAL_OUTGOING_WRAPUP")
	String totalOutgoingWrapup;
	
	@Column(name="TOTAL_INCOMING_RING_DURATION")
	String totalIncomingRingDuration;
	
	@Column(name="TOTAL_OUTGOING_RING_DURATION")
	String totalOutgoingRingDuration;
	
	@Column(name="TOTAL_HOLD_DURATION")
	String totalHoldDuration;
	
	@Column(name="WORK_DURATION")
	String workDuration;
	
	@Column(name="LOGIN_TIME")
	String loginTime;
	
	@Column(name="LOGOUT_TIME")
	String logoutTime;
	
	@Column(name="FIRST_CALL_TIME")
	String firstCallTime;
	
	@Column(name="LAST_CALL_TIME")
	String lastCallTime;

}
