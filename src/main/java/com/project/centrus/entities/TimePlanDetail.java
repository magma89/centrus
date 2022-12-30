package com.project.centrus.entities;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TIME_PLAN_DETAIL")
public class TimePlanDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIME_PLAN_DETAIL_ID")
	Long timePlanDetail;
	
	
	@Column(name="TIME_PLAN_ID")
	Long timePlanId;
	
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
