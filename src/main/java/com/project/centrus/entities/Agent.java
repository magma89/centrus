package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
import lombok.Data;

@Entity
@Table(name="AGENT")
@Data
public class Agent {

	@Id
	@Column(name="AID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long AID;
	
	String NAME;
	String USERNAME;
	String PASSWORD;
	String EXT;
	String ROLE;
	String USER_TYPE;
	Integer LANGUAGE_ID;
	Integer MAX_FAIL_BEFORE_SUSPEND;
	String HOME;
	String GSM;
	Integer DELETION_ORDER;
	String SRV_PROV_CODE;
	Integer CALL_TRANSFER;
	String EMAIL;
	String OUTBOUND_CLI;
	String STATUS;
	String IS_WEB_AGENT;
	String INTRO_STATUS;
	String PROFILE;
	String APPROVAL;
	String ADSOYAD;
	Integer CRM_STATUS;
	String WORK_TIME;
	Integer DOWNLOAD_ENABLED;
	
	@Transient 
	String newp;

	 
}
