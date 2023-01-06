package com.project.centrus.model;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data 
@Table(name="WARN_SETTINGS")
public class WarnQueueNames {

	@Id
	@Column(name="ID") 
	Long id;
	
	@Column(name="QID")
	Long qid;
	
	@Column(name="MAX_WAIT_CALL")
	Integer maxWaitCall;
	
	@Column(name="MAX_STANDBY_AGENTS")
	Integer maxStandbyAgents;
	
	@Column(name="MIN_AR")
	Integer minAr;
	  
	@Column(name="NAME")
	String queueName;
}
