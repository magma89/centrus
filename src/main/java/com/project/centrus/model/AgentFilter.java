package com.project.centrus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor 
public class AgentFilter {
	
	@Id
	@Column(name="AID")
	Long aid;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="EXT")
	String ext;
	
	@Column(name="ROLE")
	String role;
	
	@Column(name="LANGUAGE_ID")
	Integer languageId;
	
	@Column(name="MAX_FAIL_BEFORE_SUSPEND")
	Integer maxFailBeforeSuspend;
	
	@Column(name="HOME")
	String home;
	
	@Column(name="GSM")
	String gsm;
	
	@Column(name="CALL_TRANSFER")
	Integer callTransfer;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="DOWNLOAD_ENABLED")
	Integer downloadEnabled;
	 
	
	@Column(name="SEAT_IP")
	String seatIp;
	
	@Column(name="SEAT_ID")
	Integer seatId;
	
	

}
