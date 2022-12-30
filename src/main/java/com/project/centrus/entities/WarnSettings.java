package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="WARN_SETTINGS")
public class WarnSettings {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="QID")
	Long qid;
	
	@Column(name="MAX_WAIT_CALL")
	Integer maxWaitCall;
	
	@Column(name="MAX_STANDBY_AGENTS")
	Integer maxStandbyAgents;
	
	@Column(name="MIN_AR")
	Integer minAr;

}
