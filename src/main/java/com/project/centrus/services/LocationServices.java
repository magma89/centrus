package com.project.centrus.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.centrus.entities.Location;
import com.project.centrus.repos.ILocationRepository;
 

@Service 
public class LocationServices {
	
	ILocationRepository locationRepository;

	public LocationServices(ILocationRepository locationRepository) { 
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getlocation(){
		return locationRepository.findAll();
	}
	
	public ResponseEntity<Object> createLocations(String message,HttpStatus status , @RequestBody Location newLocation){
		locationRepository.save(newLocation);
		 Map<String, Object> map = new HashMap<String, Object>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("locationId", newLocation.getLocationId());
      return new ResponseEntity<Object>(map,status);
	}
	
	public ResponseEntity<Object> updateLocations(String message,HttpStatus status,@PathVariable Long lid,@RequestBody Location updateLocation){
		Optional<Location> location = locationRepository.findById(lid);
		if(location.isPresent()) {
			Location foundLocation = location.get(); 
			foundLocation.setDescription(updateLocation.getDescription());
			locationRepository.save(foundLocation);
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", message);
	         map.put("status", status.value());
	         map.put("locationId", foundLocation.getLocationId());
	      return new ResponseEntity<Object>(map,status);
		}else {
			 Map<String, Object> map = new HashMap<String, Object>();
	         map.put("message", "Id Not Found");
	         map.put("status", status.value());
	         map.put("locationId", updateLocation.getLocationId());
	      return new ResponseEntity<Object>(map,status);
		}
		
	}
	
	public ResponseEntity<Object> deleteLocations(String message,HttpStatus status,@PathVariable Long lid){
		locationRepository.deleteById(lid);
		 Map<String, Object> map = new HashMap<String, Object>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("locationId", lid);
         return new ResponseEntity<Object>(map,status);
		
	}
	
	
			 
}
