package com.project.centrus.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.AssignGroup;
import com.project.centrus.entities.QueueAgentGroup;
import com.project.centrus.services.AssignGroupQueueServices;
import com.project.centrus.services.AssignGroupServices;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/assigngroup")
public class AssignGroupControllers {

//	IAssignGroupRepository agentgroupRepository;
//	
//	public AssignGroupControllers(IAssignGroupRepository agentgroupRepository) {
//		this.agentgroupRepository = agentgroupRepository;
//	}
	
	private AssignGroupServices assignGroupServices;
	private AssignGroupQueueServices assignGroupQueueServices;
	
	
	
	public AssignGroupControllers(AssignGroupServices assignGroupServices,AssignGroupQueueServices assignGroupQueueServices ) { 
		this.assignGroupServices = assignGroupServices;
		this.assignGroupQueueServices = assignGroupQueueServices;
	}



	@GetMapping
	public List<AssignGroup> getAgentGroup(){
		return assignGroupServices.getAgentGroupList();
	}
	
	@PutMapping("/delete/{qagid}")
	public ResponseEntity<String> deleteQeueAgentGroup(@PathVariable ("qagid") Long qagid){
		return assignGroupQueueServices.deleteQueueAgentGroup(qagid);
	}
	
	@PutMapping("/update/{qagid}")
	public ResponseEntity<String> updateAssignGroup(@PathVariable Long qagid, @RequestBody QueueAgentGroup newAgentGroup){
		log.info("GELEN ISTEK " + newAgentGroup);
		return assignGroupQueueServices.updateQueueAgentGroup(qagid, newAgentGroup);
	}
	
//	private AgentGroupServices agentgroupServices;
//
//	public AgentGroupController(AgentGroupServices agentgroupServices) { 
//		this.agentgroupServices = agentgroupServices;
//	}

//	@GetMapping
//	public List<AgentGroup> getAgentGroupList(){
//		return agentgroupServices.getAgentGroupList();
//	}
}
