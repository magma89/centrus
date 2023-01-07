package com.project.centrus.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.TimePlan;
import com.project.centrus.model.AlarmProperties;
import com.project.centrus.model.CallReject;
import com.project.centrus.model.SettingsParameter;
import com.project.centrus.services.SettingsServices;

@RestController
@RequestMapping("/settings")
@CrossOrigin
public class SettingsControllers {
	
	private SettingsServices settingsServices;

	public SettingsControllers(SettingsServices settingsServices) { 
		this.settingsServices = settingsServices;
	}
	
	@GetMapping("/callrejection")
	public List<CallReject> getCallReject(){
		return settingsServices.getCallReject();
	}
	
	@PutMapping("/callrejection/update/{id}")
	public ResponseEntity<Object> updateCallRejection(@PathVariable Long id, @RequestBody CallReject updateCallRejection){
		try {
			return settingsServices.updateCallRejection("Success",HttpStatus.OK,id,updateCallRejection);
		}catch (Exception e) {
			return settingsServices.updateCallRejection(e.getMessage(),HttpStatus.MULTI_STATUS,null,null);
		}
	}
	
	@GetMapping("/console")
	public List<SettingsParameter> getCallParameter(){
		return settingsServices.getCallParameter();
	}
	
	@PutMapping("/console/update/{id}")
	public ResponseEntity<Object> updateConsole(@PathVariable Long id, @RequestBody SettingsParameter updateConsole){
		try {
			return settingsServices.updateConsole("Success",HttpStatus.OK,id,updateConsole);
		}catch (Exception e) {
			return settingsServices.updateConsole(e.getMessage(),HttpStatus.MULTI_STATUS,null,null);
		}
	}
	
	@GetMapping("/alarm")
	public List<AlarmProperties> getCallAlarmProperties(){
		return settingsServices.getCallAlarmProperties();
	}
	
	@PutMapping("/alarm/update/{id}")
	public ResponseEntity<Object> updateAlarmProperties(@PathVariable Long id, @RequestBody AlarmProperties updateAlarmProperties){
		try {
			return settingsServices.updateAlarmProperties("Success",HttpStatus.OK,id,updateAlarmProperties);
		}catch (Exception e) {
			return settingsServices.updateAlarmProperties(e.getMessage(),HttpStatus.MULTI_STATUS,null,null);
		}
	}
	

}
