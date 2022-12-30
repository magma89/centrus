package com.project.centrus.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.ChargingSystem;
import com.project.centrus.services.ChargingSystemServices;
 

@CrossOrigin
@RestController
@RequestMapping("/charging")
public class ChargingSystemControllers {

	private ChargingSystemServices chargingSystemServices;

	public ChargingSystemControllers(ChargingSystemServices chargingSystemServices) { 
		this.chargingSystemServices = chargingSystemServices;
	}
	
	@GetMapping
	public List<ChargingSystem> getChargingSystem(){
		return chargingSystemServices.getChargingSystem();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateChargingSystem(@RequestBody ChargingSystem updateChargingField){
		return chargingSystemServices.updateChargingSystem("Updated",HttpStatus.OK,updateChargingField);
	}
}
