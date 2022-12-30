package com.project.centrus.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/console")
	public List<SettingsParameter> getCallParameter(){
		return settingsServices.getCallParameter();
	}
	
	@GetMapping("/alarm")
	public List<AlarmProperties> getCallAlarmProperties(){
		return settingsServices.getCallAlarmProperties();
	}
	

}
