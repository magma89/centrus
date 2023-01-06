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
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.Location;
import com.project.centrus.services.LocationServices;
 

@CrossOrigin
@RestController
@RequestMapping("/locations")
public class LocationControllers {
	private LocationServices locationServices;

	public LocationControllers(LocationServices locationServices) { 
		this.locationServices = locationServices;
	}
	
	@GetMapping
	public List<Location> getlocation(){
		return locationServices.getlocation();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> createLocations(@RequestBody Location newLocation){
		try {
			return locationServices.createLocations("Success",HttpStatus.OK,newLocation);
		}catch (Exception e) {
			return locationServices.createLocations(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
		
	}
	
	@PutMapping("/update/{lid}")
	public ResponseEntity<Object> updateLocations(@PathVariable Long lid,@RequestBody Location updateLocation){
		try {
			return locationServices.updateLocations("Success",HttpStatus.OK,lid,updateLocation);
		}catch (Exception e) {
			return locationServices.updateLocations(e.getMessage(),HttpStatus.MULTI_STATUS,null,null);
		}
	}
	
	@DeleteMapping("/delete/{lid}")
	public ResponseEntity<Object> deleteLocations(@PathVariable Long lid){
		try {
			return locationServices.deleteLocations("Success",HttpStatus.OK,lid);
		}catch(Exception e) {
			return locationServices.deleteLocations(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}

}
