package com.project.centrus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.centrus.entities.WarnEmail;
import com.project.centrus.entities.WarnGsm;
import com.project.centrus.entities.WarnSettings;
import com.project.centrus.repos.IWarnEmailRepository;
import com.project.centrus.repos.IWarnGsmRepository;
import com.project.centrus.repos.IWarnSettingsRepository;
 
@Service
public class WarnSettingsServices {
	
	 IWarnSettingsRepository iWarnSettingsRepository;
	 IWarnEmailRepository iWarnEmailRepository;
	 IWarnGsmRepository iWarnGsmRepository;

	public WarnSettingsServices(IWarnSettingsRepository iWarnSettingsRepository,IWarnEmailRepository iWarnEmailRepository,IWarnGsmRepository iWarnGsmRepository) { 
		this.iWarnSettingsRepository = iWarnSettingsRepository;
		this.iWarnEmailRepository=iWarnEmailRepository;
		this.iWarnGsmRepository=iWarnGsmRepository;
	}
	
	public List<WarnSettings> getWarnSettings(){
		return iWarnSettingsRepository.findAll();
	}
	
	public List<WarnGsm> getWarnGsmList(){
		return iWarnGsmRepository.findAll();
	}
	
	public List<WarnEmail> getWarnEmailList(){
		return iWarnEmailRepository.findAll();
	}
	 
}
