package com.project.centrus.services;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.centrus.entities.AgentGroup;
import com.project.centrus.entities.GroupMembers;
import com.project.centrus.entities.SuspendReason;
import com.project.centrus.model.AgentGroupNames;
import com.project.centrus.model.Members;
import com.project.centrus.repos.IAgentGroupRepository;
import com.project.centrus.repos.IGMRepository;
import com.project.centrus.repos.IGroupMembersRepository;
import com.project.centrus.repos.ISuspendRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AgentGroupServices {
	
	IAgentGroupRepository agentGroupRepository; 
	IGMRepository gmRepository;
	IGroupMembersRepository groupRepository;
	ISuspendRepository suspendRepository;
	
	public AgentGroupServices(IAgentGroupRepository agentGroupRepository, IGMRepository gmRepository, IGroupMembersRepository groupRepository,ISuspendRepository suspendRepository) {
		this.agentGroupRepository = agentGroupRepository;
		this.gmRepository = gmRepository;
		this.groupRepository = groupRepository;
		this.suspendRepository = suspendRepository;
	}

	

 
	
	public List<AgentGroup> getAllGroupAgent(){
		return agentGroupRepository.getAllGroupAgent();
		
	}
	
	public List<AgentGroupNames> getAllGroupNames(){
		List<AgentGroupNames> groupnames = new ArrayList<>();
		List<AgentGroup> agnames = agentGroupRepository.getAllGroupAgent();
		for (AgentGroup tempNames : agnames) {
			groupnames.add(new AgentGroupNames(tempNames.getAGID(), tempNames.getDescription()));
		}
		return groupnames;
		
	}
	
	public List<Members> getMembers(@PathVariable Long agid){
		log.info("Service gelen istek " + agid);
		return gmRepository.getGroupMembers(agid);
	}
	
	public ResponseEntity<Object> deleteMembers(String message, HttpStatus status,@PathVariable Long agid){
		Optional<AgentGroup> members = agentGroupRepository.findById(agid);
		if(members.isPresent()) {
			AgentGroup foundMembers = members.get();
			foundMembers.setDeletionOrder(99);
			agentGroupRepository.save(foundMembers);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("deleteid", foundMembers.getAGID());
			return new ResponseEntity<Object>(map,status);
		}  else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("data","Id Not Found");
			return new ResponseEntity<Object>(map,status);
		}
	}
	
	public ResponseEntity<Object> createGroup(String message, HttpStatus status,@RequestBody AgentGroup newAgentGroup){
		agentGroupRepository.save(newAgentGroup);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("agid", newAgentGroup.getAGID());
		return new ResponseEntity<Object>(map,status);
	}
	
	public ResponseEntity<Object> updateGroup(String message, HttpStatus status, @PathVariable Long agid ,@RequestBody AgentGroup updateGroup){
		Optional<AgentGroup> members = agentGroupRepository.findById(agid); 
		if(members.isPresent()) {
			AgentGroup foundMembers = members.get();
			foundMembers.setAcdMethod(updateGroup.getAcdMethod());
			foundMembers.setDescription(updateGroup.getDescription());
			foundMembers.setRecordFlag(updateGroup.getRecordFlag());
			foundMembers.setGroupLeaderId(updateGroup.getGroupLeaderId());
			agentGroupRepository.save(foundMembers);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("updateid", agid);
			return new ResponseEntity<Object>(map,status);
		}else {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("data", "Id Not Found");
			return new ResponseEntity<Object>(map,status);
		}
	}
	
	public ResponseEntity<Object> updateMembers(String message, HttpStatus status,@PathVariable Long gmid,@RequestBody GroupMembers updateMembers){
		Optional<GroupMembers> members = groupRepository.findById(gmid);
		if(members.isPresent()) {
			GroupMembers presentMembers = members.get(); 
			groupRepository.deleteById(presentMembers.getGmid());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("deletedId", presentMembers.getGmid());
			return new ResponseEntity<Object>(map,status);
		}else {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("data", "Id Not Found");
			return new ResponseEntity<Object>(map,status);
		}
		
	}
	
	public ResponseEntity<Object> addMembers(String message,HttpStatus status,@RequestBody GroupMembers addMembers){
		log.info("Gelen Members ID " + addMembers);
		groupRepository.save(addMembers);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("data", addMembers.getGmid());
		return new ResponseEntity<Object>(map,status);
	}
	
	public List<SuspendReason> getSuspends(){
		return suspendRepository.findAll(); 
	}
	
	
	public ResponseEntity<Object> suspendAdd(String message,HttpStatus status,@RequestBody SuspendReason addSuspend){
		Integer listOrder = suspendRepository.getListOrder();
		listOrder = listOrder + 1;
		addSuspend.setListOrder(listOrder);
		addSuspend.setIconId(99);
		addSuspend.setSuspendid((long) listOrder);
		addSuspend.getSuspendDescription();  
		suspendRepository.save(addSuspend);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("suspendId", addSuspend.getSuspendid());
		return new ResponseEntity<Object>(map,status);
	}
	
	
	public ResponseEntity<Object> deleteSuspend(String message,HttpStatus status,@PathVariable Long suspendid){
		Optional<SuspendReason> suspend = suspendRepository.findById(suspendid);
		if(suspend.isPresent()) {
			SuspendReason presentSuspend = suspend.get();
			suspendRepository.deleteById(suspendid);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Deleted");
			map.put("status", status.value());
			map.put("deleteId", presentSuspend.getSuspendid());
			return new ResponseEntity<Object>(map,status);
		}else {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("message", "Not Deleted");
			map.put("status", status.value());
			map.put("data", "Id Not Found");
			return new ResponseEntity<Object>(map,status);
		}
	}
	
 
}
