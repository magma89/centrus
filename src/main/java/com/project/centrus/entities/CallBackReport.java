package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class CallBackReport {
	
	@Id
	@Column(name="DATE")
	String date;
	
	@Column(name="TIME")
	String time;
	
	@Column(name="QUEUE_NAME")
	String queuename;
	
	@Column(name="MESSAGING_NUMBER")
	String messagingNumber;

}
