package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="AGENT_GROUP")
@Data
public class AgentGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AGID")
	Long AGID;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="RECORD_FLAG")
	Integer recordFlag;
	
	@Column(name="ACD_METHOD")
	Integer acdMethod;
	
	String AG_TYPE = "CC_AG";
	
	@Column(name="DELETION_ORDER")
	Integer deletionOrder = 0;
	String SRV_PROV_CODE = "01";
	
	@Column(name="GROUP_LEADER_ID")
	Integer groupLeaderId;
	

}
