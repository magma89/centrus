package com.project.centrus.model;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
 
import lombok.Data; 
@Data
@Entity
public class TimeModel {
	 
	@Id
	@Column(name="TIME_PLAN_NAME")
	String timePlanName;
	 
	@Column(name="QID")
	Integer qid;

	@Column(name="MON_START")
	String monStart;
 	
	@Column(name="MON_END")
	String monEnd;
 	
	@Column(name="TUE_START")
	String tueStart;
 	
	@Column(name="TUE_END")
	String tueEnd;
 	
	@Column(name="WED_START")
	String wedStart;
 	
	@Column(name="WED_END")
	String wedEnd;
 	
	@Column(name="THU_START")
	String thuStart;
 	
	@Column(name="THU_END")
	String thuEnd;
 	
	@Column(name="FRI_START")
	String friStart;
 	
	@Column(name="FRI_END")
	String friEnd;
 	
	@Column(name="SAT_START")
	String satStart;
 	
	@Column(name="SAT_END")
	String satEnd;
 	
	@Column(name="SUN_START")
	String sunStart;
 	
	@Column(name="SUN_END")
	String sunEnd;

}
