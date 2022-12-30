package com.project.centrus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public List<SettingsParameter> getCallParameter(){
		List<SettingsParameter> parameter = new ArrayList<>();
		List<Settings> consoleParam = settingsRepository.findAll();
		for (Settings tempSettings : consoleParam) {
			parameter.add(new SettingsParameter(tempSettings.getId(), tempSettings.getPerCallCharging(),tempSettings.getFreeService(),tempSettings.getFreeServiceInSec()
					,tempSettings.getIgnoreChargingForPostpaid(),tempSettings.getIgnoreChargingForPrepaid()));
		}
		return parameter;
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
	
} 
