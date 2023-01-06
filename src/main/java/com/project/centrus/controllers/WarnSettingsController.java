package com.project.centrus.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.WarnEmail;
import com.project.centrus.entities.WarnGsm;
import com.project.centrus.entities.WarnSettings;
import com.project.centrus.model.WarnQueueNames;
import com.project.centrus.services.WarnSettingsServices;

@CrossOrigin
@RestController
@RequestMapping("/warnsettings")
public class WarnSettingsController {
	
	private WarnSettingsServices warnSettingsServices;
	

	public WarnSettingsController(WarnSettingsServices warnSettingsServices) { 
		this.warnSettingsServices = warnSettingsServices;
	}
	
	@GetMapping
	public List<WarnQueueNames> getWarnSettings(){
		return warnSettingsServices.getWarnSettings();
	}
	
	@GetMapping("/gsm")
	public List<WarnGsm> getWarnGsmList(){
		return warnSettingsServices.getWarnGsmList();
	}
	
	@GetMapping("/email")
	public List<WarnEmail> getWarnEmailList(){
		return warnSettingsServices.getWarnEmailList();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> createSettings(@RequestBody WarnSettings newSettings){
		try {
			return warnSettingsServices.createSettings("Success",HttpStatus.OK,newSettings);
		}catch(Exception e) {
			return warnSettingsServices.createSettings(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}

}
