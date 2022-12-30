package com.project.centrus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.centrus.entities.AssignGroup;
import com.project.centrus.repos.IAssignGroupRepository;

@Service
public class AssignGroupServices {

	IAssignGroupRepository assignGroupRepository;

	public AssignGroupServices(IAssignGroupRepository assignGroupRepository) { 
		this.assignGroupRepository = assignGroupRepository;
	}
	
	
 
	public List<AssignGroup> getAgentGroupList(){
		return assignGroupRepository.getAgentGroupAssign(); 
	}
}
