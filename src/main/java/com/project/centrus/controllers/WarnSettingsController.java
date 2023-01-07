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
	

	
	@PostMapping("/add")
	public ResponseEntity<Object> createSettings(@RequestBody WarnSettings newSettings){
		try {
			return warnSettingsServices.createSettings("Success",HttpStatus.OK,newSettings);
		}catch(Exception e) {
			return warnSettingsServices.createSettings(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteSettings(@PathVariable Long id){
		try {
			return warnSettingsServices.deleteSettings("Success", HttpStatus.OK, id);
		}catch(Exception e) {
			return warnSettingsServices.deleteSettings(e.getMessage(),HttpStatus.MULTI_STATUS, null);
		}
	}

	/*
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateSettings(@PathVariable Long id, @RequestBody WarnSettings updateSettings){
		try {
			return warnSettingsServices.updateSettings("Success", HttpStatus.OK, id, updateSettings);
		}catch(Exception e) {
			return warnSettingsServices.updateSettings(e.getMessage(),HttpStatus.MULTI_STATUS, null, updateSettings);
		}
	}
	*/	
	
	
	
	@GetMapping("/gsm")
	public List<WarnGsm> getWarnGsmList(){
		return warnSettingsServices.getWarnGsmList();
	}
	
	@PostMapping("/addGsm")
	public ResponseEntity<Object> createGsmList(@RequestBody WarnGsm newGsmList){
		try {
			return warnSettingsServices.createGsmList("Success",HttpStatus.OK,newGsmList);
		}catch(Exception e) {
			return warnSettingsServices.createGsmList(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}
	
	@DeleteMapping("/deleteGsm/{id}")
	public ResponseEntity<String> deleteGsmList(@PathVariable Long id){
		try {
			return warnSettingsServices.deleteGsmList("Success", HttpStatus.OK, id);
		}catch(Exception e) {
			return warnSettingsServices.deleteGsmList(e.getMessage(),HttpStatus.MULTI_STATUS, null);
		}
	}

	
	@PutMapping("/updateGsm/{id}")
	public ResponseEntity<String> updateGsmList(@PathVariable Long id, @RequestBody WarnGsm updateGsmList){
		try {
			return warnSettingsServices.updateGsmList("Success", HttpStatus.OK, id, updateGsmList);
		}catch(Exception e) {
			return warnSettingsServices.updateGsmList(e.getMessage(),HttpStatus.MULTI_STATUS, null, updateGsmList);
		}
	}
		
	
	@GetMapping("/email")
	public List<WarnEmail> getWarnEmailList(){
		return warnSettingsServices.getWarnEmailList();
	}
	
	@PostMapping("/addEmail")
	public ResponseEntity<Object> createEmailList(@RequestBody WarnEmail newEmailList){
		try {
			return warnSettingsServices.createEmailList("Success",HttpStatus.OK,newEmailList);
		}catch(Exception e) {
			return warnSettingsServices.createEmailList(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}
	
	@DeleteMapping("/deleteEmail/{id}")
	public ResponseEntity<String> deleteEmailList(@PathVariable Long id){
		try {
			return warnSettingsServices.deleteEmailList("Success", HttpStatus.OK, id);
		}catch(Exception e) {
			return warnSettingsServices.deleteEmailList(e.getMessage(),HttpStatus.MULTI_STATUS, null);
		}
	}

	
	@PutMapping("/updateEmail/{id}")
	public ResponseEntity<String> updateEmailList(@PathVariable Long id, @RequestBody WarnEmail updateEmailList){
		try {
			return warnSettingsServices.updateEmailList("Success", HttpStatus.OK, id, updateEmailList);
		}catch(Exception e) {
			return warnSettingsServices.updateEmailList(e.getMessage(),HttpStatus.MULTI_STATUS, null, updateEmailList);
		}
	}
	
}
