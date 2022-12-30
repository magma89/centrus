package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="PORT_SELECTION_ORDER")
public class PortSelectionRules {
	
	
	@Id
	@Column(name="RULE_ID")
	Long ruleId;
	
	@Column(name="CALLED_NUM")
	String calledNum;
	
	@Column(name="MATCH_TYPE")
	String matchType;
	
	@Column(name="PRIORITY")
	Integer priority;
	
	@Column(name="FIRST_PORT_ID")
	Integer firstPortId;
	
	@Column(name="LAST_PORT_ID")
	Integer lastPortId;
	
	@Column(name="SERVICE_CODE")
	String serviceCode;

}

	