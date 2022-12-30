package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SETTINGS")
public class Settings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	Long id;
	
	@Column(name="PER_CALL_CHARGING")
	Integer perCallCharging;
	
	@Column(name="FREE_SERVICE")
	Integer freeService;
	
	@Column(name="FREE_SERVICE_IN_SEC")
	Integer freeServiceInSec;
	
	@Column(name="CALL_REJECTION_RIGHT")
	Integer callRejectionRight;
	
	@Column(name="VOICE_MAIL_ADDR")
	String voiceMailAddr;
	
	@Column(name="IGNORE_CHARGING_FOR_PREPAID")
	Integer ignoreChargingForPrepaid;
	
	@Column(name="IGNORE_CHARGING_FOR_POSTPAID")
	Integer ignoreChargingForPostpaid;
	
	@Column(name="CCM_TOTAL_QUEUE_SIZE_THOLD")
	Integer ccmTotalQueueSizeThold;
	
	@Column(name="CCM_TOTAL_QUEUE_SIZE_ALARM_INT")
	Integer ccmTotalQueueSizeAlarmInt;
	
	@Column(name="CCM_SUSP_AGENT_CNT_THOLD")
	Integer ccmSuspAgentCntThold;
	
	@Column(name="CCM_SUSP_AGENT_CNT_ALARM_INT")
	Integer ccmSuspAgentCntAlarmInt;
	
	@Column(name="CCM_SL_ALARM_RATIO")
	Integer ccmSlAlarmRatio;
	
	@Column(name="CCM_SL_ALARM_ANSWER_THOLD")
	Integer ccmSlAlarmAnswerThold;
	
	@Column(name="CCM_SL_ALARM_INT")
	Integer ccmSlAlarmInt;
	
	
}
