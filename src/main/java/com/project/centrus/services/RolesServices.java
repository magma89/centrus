package com.project.centrus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.centrus.entities.Roles;
import com.project.centrus.repos.IRolesRepository;

@Service
public class RolesServices {
	
	IRolesRepository rolesRepository;

	public RolesServices(IRolesRepository rolesRepository) { 
		this.rolesRepository = rolesRepository;
	}
	
	public List<Roles> getRoles(){
		return rolesRepository.findAll();
	}

}
