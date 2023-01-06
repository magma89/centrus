package com.project.centrus.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.Roles;
import com.project.centrus.services.RolesServices;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesControllers {
	
	private RolesServices rolesServices;
	
	public RolesControllers(RolesServices rolesServices) { 
		this.rolesServices = rolesServices;
	}

	@GetMapping
	public List<Roles> getRoles(){
		return rolesServices.getRoles();
		
	}

}
