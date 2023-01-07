package com.project.centrus.controllers;

 

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.TimePlan;
import com.project.centrus.model.TimeModel;
import com.project.centrus.services.TimePlanServices;

@CrossOrigin
@RestController
@RequestMapping("/timeplan")
public class TimePlanControllers {
	
	private TimePlanServices timePlanServices;

	public TimePlanControllers(TimePlanServices timePlanServices) { 
		this.timePlanServices = timePlanServices;
	}
	
	@GetMapping
	public List<TimePlan> getTimePlan(){
		return timePlanServices.getTimePlan();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addTimePlan(@RequestBody TimePlan newtimePlan){
		return timePlanServices.addTimePlan("Added",HttpStatus.OK,newtimePlan);
	}
	
	@DeleteMapping("/delete/{tid}")
	public ResponseEntity<Object> deleteTimePlan(@PathVariable Long tid){
		return timePlanServices.deleteTimePlan("Deleted",HttpStatus.OK,tid);
	}
	
	@PutMapping("/update/{tid}")
	public ResponseEntity<Object> updateTimePlan(@PathVariable Long tid, @RequestBody TimePlan updateTimePlan){
		return timePlanServices.updateTimePlan("Updated", HttpStatus.OK, tid, updateTimePlan);
	}
	
	@GetMapping("/detail/{tid}")
	public List<TimeModel> timePlanDetail(@PathVariable Long tid){
		return timePlanServices.timePlanDetail(tid);
	}
	
	
	
}
