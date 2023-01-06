package com.project.centrus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.WarnEmail;
import com.project.centrus.entities.WarnGsm;
import com.project.centrus.entities.WarnSettings;
import com.project.centrus.model.SettingsModel;
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
	
	public List<WarnGsm> getWarnGsmList(){
		return iWarnGsmRepository.findAll();
	}
	
	public List<WarnEmail> getWarnEmailList(){
		return iWarnEmailRepository.findAll();
	}
	
	public ResponseEntity<Object> createSettings(String message,HttpStatus status,@RequestBody WarnSettings newSettings){
		iWarnSettingsRepository.save(newSettings);
		 Map<String, Object> map = new HashMap<String, Object>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("Desc", "Settings Added");
      return new ResponseEntity<Object>(map,status);
	}
	 
}
