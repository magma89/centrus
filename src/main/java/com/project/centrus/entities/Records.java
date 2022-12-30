package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Records {
	
	@Id
	Long id;
	
	@Column(name="FILEPATH")
	String filePath;
	
	@Column(name="FILENAME")
	String fileName;
	
	@Column(name="FILESIZE")
	String fileSize;
	
	@Column(name="STARTTIME")
	String startTime;
	
	@Column(name="ENDTIME")
	String endTime;
	
	@Column(name="CLASS")
	String recordClass;
	
	@Column(name="AGENTNAME")
	String agentName;
	
	@Column(name="QUEUENAME")
	String queueName;
	
	@Column(name="AGENTDID")
	String agentDid;
	
	@Column(name="DATA")
	String data;
	
	@Column(name="DURATION_IN_SECONDS")
	String durationInSeconds;
	
	@Column(name="MSISDN")
	String msisdn;
	
	
}
