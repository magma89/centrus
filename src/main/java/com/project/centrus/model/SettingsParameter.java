package com.project.centrus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class SettingsParameter {
	
	@Id
	@Column(name="ID")
	Long id;
	
	@Column(name="PER_CALL_CHARGING")
	Integer perCallCharging;
	
	@Column(name="FREE_SERVICE")
	Integer freeService;
	
	@Column(name="FREE_SERVICE_IN_SEC")
	Integer freeServiceInSec;

	@Column(name="IGNORE_CHARGING_FOR_PREPAID")
	Integer ignoreChargingForPrepaid;
	
	@Column(name="IGNORE_CHARGING_FOR_POSTPAID")
	Integer ignoreChargingForPostpaid;
}
