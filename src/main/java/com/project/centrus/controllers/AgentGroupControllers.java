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

import com.project.centrus.entities.AgentGroup;
import com.project.centrus.entities.GroupMembers;
import com.project.centrus.entities.SuspendReason;
import com.project.centrus.model.AgentGroupNames;
import com.project.centrus.model.Members;
import com.project.centrus.services.AgentGroupServices;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/agentgroup")
@Slf4j
public class AgentGroupControllers {
	
	//IAgentGroupRepository agentGroupRepository;

//	public AgentGroupControllers(IAgentGroupRepository agentGroupRepository) { 
//		this.agentGroupRepository = agentGroupRepository;
//	}
	
	private AgentGroupServices agentGroupServices;
	
	
	
	public AgentGroupControllers(AgentGroupServices agentGroupServices) { 
		this.agentGroupServices = agentGroupServices;
	}


	@GetMapping
	public List<AgentGroup> getAllAgentGroup(){
		return agentGroupServices.getAllGroupAgent();
	}
	
	@GetMapping("/names")
	public List<AgentGroupNames> getAllNames(){
		return agentGroupServices.getAllGroupNames();
	}
	
	@GetMapping("/members/{agid}")
	public List<Members> getAllMembers(@PathVariable Long agid){
		log.info("Gelen İstek " + agid);
		return agentGroupServices.getMembers(agid);
	}
	
	@DeleteMapping("/delete/members/{agid}")
	public ResponseEntity<Object> deleteGroupMembers(@PathVariable Long agid){
		return agentGroupServices.deleteMembers("Deleted",HttpStatus.OK, agid);
	}
	
	@PutMapping("/update/members/{gmid}")
	public ResponseEntity<Object> updateGroupMembers(@PathVariable Long gmid, @RequestBody GroupMembers updateMembers){
		return agentGroupServices.updateMembers("Updated",HttpStatus.OK,gmid,updateMembers);
	}
	
	@PostMapping("/addmembers")
	public ResponseEntity<Object> addGroupMember(@RequestBody GroupMembers addMembers){
		return agentGroupServices.addMembers("Added",HttpStatus.OK,addMembers);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Object> createAgentGroup(@RequestBody AgentGroup newAgentGroup){
		log.info("Gelen Add İstegi " + newAgentGroup);
		return agentGroupServices.createGroup("Added",HttpStatus.OK,newAgentGroup);
	}
	
	@PutMapping("/update/{agid}")
	public ResponseEntity<Object> updateAgentGroup(@PathVariable Long agid, @RequestBody AgentGroup updateGroup){
		log.info("Update İstegi " + updateGroup);
		return agentGroupServices.updateGroup("Updated",HttpStatus.OK,agid,updateGroup);
	}
	
	@DeleteMapping("/delete/{agid}")
	public ResponseEntity<Object> deleteAgentGroup(@PathVariable Long agid){
		log.info("Delete İstegi " + agid);
		return agentGroupServices.deleteGroup("Deleted",HttpStatus.OK,agid);
	}
	
	
	@GetMapping("/suspendreason")
	public List<SuspendReason> getSuspendReason(){
		return agentGroupServices.getSuspends();
	}
	
	@PostMapping("/suspend/add")
	public ResponseEntity<Object> addSuspend(@RequestBody SuspendReason addSuspend){
		return agentGroupServices.suspendAdd("Added",HttpStatus.OK,addSuspend);
	}
	
	@DeleteMapping("/suspend/delete/{suspendid}")
	public ResponseEntity<Object> deleteSuspend(String message,@PathVariable Long suspendid){
		return agentGroupServices.deleteSuspend(message,HttpStatus.OK,suspendid);
	}
	
	@PutMapping("/suspend/update/{suspendid}")
	public ResponseEntity<Object> updateSuspend(@PathVariable Long suspendid, @RequestBody SuspendReason updateSuspend){
		return agentGroupServices.updateSuspend("Updated", HttpStatus.OK, suspendid, updateSuspend);
	}

}
