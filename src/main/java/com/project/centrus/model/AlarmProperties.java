package com.project.centrus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class AlarmProperties {

	@Id
	@Column(name="ID")
	Long id;
	
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
