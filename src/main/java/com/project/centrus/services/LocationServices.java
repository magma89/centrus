package com.project.centrus.services;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
