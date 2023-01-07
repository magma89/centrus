package com.project.centrus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.centrus.entities.Location;
import com.project.centrus.entities.Settings;
import com.project.centrus.model.AlarmProperties;
import com.project.centrus.model.CallReject;
import com.project.centrus.model.SettingsParameter;
import com.project.centrus.repos.ISettingsRepository;

@Service
public class SettingsServices {
	
	ISettingsRepository settingsRepository;

	public SettingsServices(ISettingsRepository settingsRepository) { 
		this.settingsRepository = settingsRepository;
	}
	
//	public Integer getcallreject(){
//		Integer reject = settingsRepository.getById((long) 1).getCallRejectionRight();
//		return reject;
//	}

	public List<CallReject> getCallReject(){
		List<CallReject> callReject = new ArrayList<>();
		List<Settings> reject = settingsRepository.findAll();
		for (Settings tempSettings : reject) {
			callReject.add(new CallReject(tempSettings.getId(), tempSettings.getCallRejectionRight()));
		}
		return callReject;
	}
	
	public ResponseEntity<Object> updateCallRejection(String message, HttpStatus status, Long id,
			CallReject updateCallRejection) {
		Optional<Settings> callReject = settingsRepository.findById(id);
		if(callReject.isPresent()) {
			Settings foundCallReject = callReject.get(); 
			foundCallReject.setCallRejectionRight(updateCallRejection.getCallReject());
			settingsRepository.save(foundCallReject);
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", message);
	         map.put("status", status.value());
	         map.put("callRejectId", foundCallReject.getId());
	      return new ResponseEntity<Object>(map,status);
		}else {
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", "Id Not Found");
	         map.put("status", status.value());
	         map.put("callRejectId", updateCallRejection.getId());
	      return new ResponseEntity<Object>(map,status);
		}
	}
	
	
	
	
	
	
	public List<SettingsParameter> getCallParameter(){
		List<SettingsParameter> parameter = new ArrayList<>();
		List<Settings> consoleParam = settingsRepository.findAll();
		for (Settings tempSettings : consoleParam) {
			parameter.add(new SettingsParameter(tempSettings.getId(), tempSettings.getPerCallCharging(),tempSettings.getFreeService(),tempSettings.getFreeServiceInSec()
					,tempSettings.getIgnoreChargingForPostpaid(),tempSettings.getIgnoreChargingForPrepaid()));
		}
		return parameter;
	}
	
	public ResponseEntity<Object> updateConsole(String message, HttpStatus status, Long id,
			SettingsParameter updateConsole) {
		Optional<Settings> console = settingsRepository.findById(id);
		if(console.isPresent()) {
			Settings foundConsole = console.get(); 
			foundConsole.setPerCallCharging(updateConsole.getPerCallCharging());
			foundConsole.setFreeService(updateConsole.getFreeService());
			foundConsole.setFreeServiceInSec(updateConsole.getFreeServiceInSec());
			foundConsole.setIgnoreChargingForPrepaid(updateConsole.getIgnoreChargingForPrepaid());
			foundConsole.setIgnoreChargingForPostpaid(updateConsole.getIgnoreChargingForPostpaid());
			settingsRepository.save(foundConsole);
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", message);
	         map.put("status", status.value());
	         map.put("consoleId", foundConsole.getId());
	      return new ResponseEntity<Object>(map,status);
		}else {
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", "Id Not Found");
	         map.put("status", status.value());
	         map.put("consoleId", updateConsole.getId());
	      return new ResponseEntity<Object>(map,status);
		}
	}
	
	
	
	
	
	public List<AlarmProperties> getCallAlarmProperties(){
		List<AlarmProperties> alarmp = new ArrayList<>();
		List<Settings> alarmParam = settingsRepository.findAll();
		for(Settings tempSettings : alarmParam) {
			alarmp.add(new AlarmProperties(tempSettings.getId(), tempSettings.getCcmTotalQueueSizeAlarmInt(), 
					tempSettings.getCcmSuspAgentCntThold(), tempSettings.getCcmSuspAgentCntAlarmInt(), tempSettings.getCcmSlAlarmRatio(),
					tempSettings.getCcmSlAlarmAnswerThold(), tempSettings.getCcmTotalQueueSizeThold(), tempSettings.getCcmSlAlarmInt()));
		}
		return alarmp;
	}

	public ResponseEntity<Object> updateAlarmProperties(String message, HttpStatus status, Long id,
			AlarmProperties updateAlarmProperties) {
		Optional<Settings> alarmProperties = settingsRepository.findById(id);
		if(alarmProperties.isPresent()) {
			Settings foundAlarmProperties = alarmProperties.get(); 
			foundAlarmProperties.setCcmTotalQueueSizeThold(updateAlarmProperties.getCcmTotalQueueSizeThold());
			foundAlarmProperties.setCcmTotalQueueSizeAlarmInt(updateAlarmProperties.getCcmTotalQueueSizeAlarmInt());
			foundAlarmProperties.setCcmSuspAgentCntThold(updateAlarmProperties.getCcmSuspAgentCntThold());
			foundAlarmProperties.setCcmSuspAgentCntAlarmInt(updateAlarmProperties.getCcmSuspAgentCntAlarmInt());
			foundAlarmProperties.setCcmSlAlarmRatio(updateAlarmProperties.getCcmSlAlarmRatio());
			foundAlarmProperties.setCcmSlAlarmAnswerThold(updateAlarmProperties.getCcmSlAlarmAnswerThold());
			foundAlarmProperties.setCcmSlAlarmInt(updateAlarmProperties.getCcmSlAlarmInt());
			settingsRepository.save(foundAlarmProperties);
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", message);
	         map.put("status", status.value());
	         map.put("alarmPropertiesId", foundAlarmProperties.getId());
	      return new ResponseEntity<Object>(map,status);
		}else {
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", "Id Not Found");
	         map.put("status", status.value());
	         map.put("alarmPropertiesId", updateAlarmProperties.getId());
	      return new ResponseEntity<Object>(map,status);
		}
	}


	
} 
