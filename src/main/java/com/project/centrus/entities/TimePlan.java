package com.project.centrus.entities;
 

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="TIME_PLAN")
@Data
public class TimePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="TIME_PLAN_ID")
	Long timePlanId;
	
	@Column(name="TIME_PLAN_NAME")
	String timePlanName;
	
	@Column(name="SRV_PROV_CODE")
	String srvProvCode = "01";
	
//	@OneToOne(targetEntity = Queue.class,fetch = FetchType.EAGER)
//	@JoinColumn(name="QID") 
//	Queue queue;
	
	@Column(name="QID")
	Integer qid;

 
	
	//@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="QID")
	//private Queue qid;
	 
	 	@Transient
		String monStart;
	 	@Transient
		String monEnd;
	 	@Transient
		String tueStart;
	 	@Transient
		String tueEnd;
	 	@Transient
		String wedStart;
	 	@Transient
		String wedEnd;
	 	@Transient
		String thuStart;
	 	@Transient
		String thuEnd;
	 	@Transient
		String friStart;
	 	@Transient
		String friEnd;
	 	@Transient
		String satStart;
	 	@Transient
		String satEnd;
	 	@Transient
		String sunStart;
	 	@Transient
		String sunEnd;
}
