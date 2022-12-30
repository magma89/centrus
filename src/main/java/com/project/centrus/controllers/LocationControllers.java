package com.project.centrus.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
