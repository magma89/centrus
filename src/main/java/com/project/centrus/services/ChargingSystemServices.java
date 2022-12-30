package com.project.centrus.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.centrus.entities.ChargingSystem;
import com.project.centrus.repos.IChargingRepository;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
public class ChargingSystemServices {

	IChargingRepository chargingRepository;

	public ChargingSystemServices(IChargingRepository chargingRepository) { 
		this.chargingRepository = chargingRepository;
	}
	
	public List<ChargingSystem> getChargingSystem(){
		return chargingRepository.findAll();
	}
	
	public ResponseEntity<Object> updateChargingSystem(String message, HttpStatus status,@RequestBody ChargingSystem updateChargingField){
		Optional<ChargingSystem> upSystem = chargingRepository.findById((long) 1);
		log.info("Gelen Request " + updateChargingField);
		if(upSystem.isPresent()) {
			ChargingSystem foundSystem = upSystem.get();
			foundSystem.setClient1HostIp(updateChargingField.getClient1HostIp());
			foundSystem.setClient1HostPort(updateChargingField.getClient1HostPort());
			foundSystem.setClient1Realm(updateChargingField.getClient1Realm());
			foundSystem.setClient2HostIp(updateChargingField.getClient2HostIp());
			foundSystem.setClient2HostPort(updateChargingField.getClient2HostPort());
			foundSystem.setClient2Realm(updateChargingField.getClient2Realm());
			foundSystem.setPrimaryHostPostpaidIp(updateChargingField.getPrimaryHostPostpaidIp());
			foundSystem.setPrimaryHostPostpaidPort(updateChargingField.getPrimaryHostPostpaidPort());
			foundSystem.setPrimaryHostPrepaidIp(updateChargingField.getPrimaryHostPrepaidIp());
			foundSystem.setPrimaryHostPrepaidPort(updateChargingField.getPrimaryHostPrepaidPort());
			foundSystem.setPrimaryRealmPostpaid(updateChargingField.getPrimaryRealmPostpaid());
			foundSystem.setPrimaryRealmPrepaid(updateChargingField.getSecondaryRealmPrepaid());
			foundSystem.setRequestTimeout(updateChargingField.getRequestTimeout());
			foundSystem.setSecondaryHostPostpaidIp(updateChargingField.getSecondaryHostPostpaidIp());
			foundSystem.setSecondaryHostPostpaidPort(updateChargingField.getSecondaryHostPostpaidPort());
			foundSystem.setSecondaryHostPrepaidIp(updateChargingField.getSecondaryHostPrepaidIp());
			foundSystem.setSecondaryHostPrepaidPort(updateChargingField.getSecondaryHostPrepaidPort());
			foundSystem.setSecondaryRealmPostpaid(updateChargingField.getSecondaryRealmPostpaid());
			foundSystem.setSecondaryRealmPrepaid(updateChargingField.getSecondaryRealmPrepaid());
			foundSystem.setSnmpIp(updateChargingField.getSnmpIp());
			foundSystem.setSnmpPort(updateChargingField.getSnmpPort());
			foundSystem.setTrafficCasePostpaid(updateChargingField.getTrafficCasePostpaid());
			foundSystem.setTrafficCasePrepaid(updateChargingField.getTrafficCasePrepaid());
			chargingRepository.save(foundSystem);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("updateid", updateChargingField.getId());
			return new ResponseEntity<Object>(map,status);
		}else {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("data", "Id Not Found");
			return new ResponseEntity<Object>(map,status);
		}
	}
}
