package com.project.centrus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.WarnEmail;
import com.project.centrus.entities.WarnGsm;
import com.project.centrus.entities.WarnSettings;
import com.project.centrus.model.WarnQueueNames;
import com.project.centrus.repos.IWarnEmailRepository;
import com.project.centrus.repos.IWarnGsmRepository;
import com.project.centrus.repos.IWarnQueueNamesRepository;
import com.project.centrus.repos.IWarnSettingsRepository;
 
@Service
public class WarnSettingsServices {
	
	 IWarnSettingsRepository iWarnSettingsRepository;
	 IWarnEmailRepository iWarnEmailRepository;
	 IWarnGsmRepository iWarnGsmRepository;
	 IWarnQueueNamesRepository iWarnQueueNames;

	public WarnSettingsServices(IWarnSettingsRepository iWarnSettingsRepository,IWarnEmailRepository iWarnEmailRepository,IWarnGsmRepository iWarnGsmRepository,IWarnQueueNamesRepository iWarnQueueNames) { 
		this.iWarnSettingsRepository = iWarnSettingsRepository;
		this.iWarnEmailRepository=iWarnEmailRepository;
		this.iWarnGsmRepository=iWarnGsmRepository;
		this.iWarnQueueNames = iWarnQueueNames;
	}
	
	public List<WarnQueueNames> getWarnSettings(){
		//return iWarnSettingsRepository.findAll();
		return iWarnQueueNames.getWarnSettings();
	}
	
	
	public ResponseEntity<Object> createSettings(String message,HttpStatus status,@RequestBody WarnSettings newSettings){
		iWarnSettingsRepository.save(newSettings);
		 Map<String, Object> map = new HashMap<String, Object>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("Desc", "Settings Added");
      return new ResponseEntity<Object>(map,status);
	}

	public ResponseEntity<Object> deleteSettings(String message, HttpStatus status, @PathVariable Long id) {
		iWarnSettingsRepository.deleteById(id);
		 Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("settingId", id);
        return new ResponseEntity<Object>(map,status);
	}

	

	/*
	public ResponseEntity<Object> updateSettings(String message, HttpStatus status, @PathVariable Long id, @RequestBody WarnSettings updateSettings) {
		Optional<WarnSettings> warnSettings = iWarnSettingsRepository.findById(id);
		Optional<WarnQueueNames> warnQueueNames = iWarnQueueNames.findById(id);
		if(warnSettings.isPresent()) {
			WarnSettings foundWarnSettings = warnSettings.get(); 
			foundWarnSettings.setQid(updateSettings.getQid());
			foundWarnSettings.setMaxWaitCall(updateSettings.getMaxWaitCall());
			foundWarnSettings.setMaxStandbyAgents(updateSettings.getMaxStandbyAgents());
			foundWarnSettings.setMinAr(updateSettings.getMinAr());
			iWarnSettingsRepository.save(foundWarnSettings);
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", message);
	         map.put("status", status.value());
	         map.put("settingId", foundWarnSettings.getId());
	      return new ResponseEntity<Object>(map,status);
		}else {
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", "Id Not Found");
	         map.put("status", status.value());
	         map.put("settingId", updateSettings.getId());
	      return new ResponseEntity<Object>(map,status);
		}
		
	}*/
	
	
	public List<WarnGsm> getWarnGsmList(){
		return iWarnGsmRepository.findAll();
	}
	
	public ResponseEntity<Object> createGsmList(String message, HttpStatus status, WarnGsm newGsmList) {
		iWarnGsmRepository.save(newGsmList);
		 Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("Desc", "Gsm List Added");
     return new ResponseEntity<Object>(map,status);
	}
	
	public ResponseEntity<String> deleteGsmList(String message, HttpStatus status, Long id) {
		Optional<WarnGsm> warnGsmList = iWarnGsmRepository.findById(id);
		if(warnGsmList.isPresent()) {
			WarnGsm deleteFound = warnGsmList.get();
			deleteFound.setDeletionOrder(99);
			iWarnGsmRepository.save(deleteFound);
			return new ResponseEntity<String>("Gsm List deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Gsm List not found !",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> updateGsmList(String message, HttpStatus status, Long id, WarnGsm updateGsmList) {
		Optional<WarnGsm> warnGsmList = iWarnGsmRepository.findById(id);	
		if(warnGsmList.isPresent()) { 
			WarnGsm updateFound = warnGsmList.get();
			updateFound.setType(updateGsmList.getType());
			updateFound.setNumber(updateGsmList.getNumber());
			iWarnGsmRepository.save(updateFound); 
			return new ResponseEntity<String>("Gsm List updated",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Gsm List not found !",HttpStatus.NOT_FOUND);
		}
	}


	 
	 
	 public List<WarnEmail> getWarnEmailList(){
		return iWarnEmailRepository.findAll();
	}	
	 
	 public ResponseEntity<Object> createEmailList(String message, HttpStatus status, WarnEmail newEmailList) {
			iWarnEmailRepository.save(newEmailList);
			 Map<String, Object> map = new HashMap<String, Object>();
	        map.put("message", message);
	        map.put("status", status.value());
	        map.put("Desc", "Email List Added");
	     return new ResponseEntity<Object>(map,status);
	}
	 
	 public ResponseEntity<String> deleteEmailList(String message, HttpStatus status, Long id) {
			Optional<WarnEmail> warnEmailList = iWarnEmailRepository.findById(id);
			if(warnEmailList.isPresent()) {
				WarnEmail deleteFound = warnEmailList.get();
				deleteFound.setDeletionOrder(99);
				iWarnEmailRepository.save(deleteFound);
				return new ResponseEntity<String>("Email List deleted",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Email List not found !",HttpStatus.NOT_FOUND);
			}
	}

	public ResponseEntity<String> updateEmailList(String message, HttpStatus status, Long id, WarnEmail updateEmailList) {
		Optional<WarnEmail> warnGsmList = iWarnEmailRepository.findById(id);	
		if(warnGsmList.isPresent()) { 
			WarnEmail updateFound = warnGsmList.get();
			updateFound.setType(updateEmailList.getType());
			updateFound.setEmail(updateEmailList.getEmail());
			iWarnEmailRepository.save(updateFound); 
			return new ResponseEntity<String>("Gsm List updated",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Gsm List not found !",HttpStatus.NOT_FOUND);
		}
	}



	
}
