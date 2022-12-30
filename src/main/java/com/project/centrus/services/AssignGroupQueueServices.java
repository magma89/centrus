package com.project.centrus.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.centrus.entities.QueueAgentGroup;
import com.project.centrus.repos.IQueueAgentGroup;
 
 
@Service
public class AssignGroupQueueServices {
	
	IQueueAgentGroup queueagentRepository;
	AgentServices agentService;

	 
 
	public AssignGroupQueueServices(IQueueAgentGroup queueagentRepository, AgentServices agentService) {
		 
		this.queueagentRepository = queueagentRepository;
		this.agentService = agentService;
	}

 
	public ResponseEntity<String> updateQueueAgentGroup(@PathVariable Long qagid, @RequestBody QueueAgentGroup newAgentGroup){
		Optional<QueueAgentGroup> queueagentgroup = queueagentRepository.findById(qagid);	
		if(queueagentgroup.isPresent()) { 
			QueueAgentGroup updateFound = queueagentgroup.get();
			updateFound.setQid(newAgentGroup.getQid());
			updateFound.setDispatchOrder(newAgentGroup.getDispatchOrder());
			updateFound.setAgid(newAgentGroup.getAgid());
			queueagentRepository.save(updateFound); 
			return new ResponseEntity<String>("The Agent Group has been successfully updated",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("The Agent Group not be updated because it was not found !",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> deleteQueueAgentGroup(@PathVariable Long qagid){
		Optional<QueueAgentGroup> queueagentgroup = queueagentRepository.findById(qagid);
		if(queueagentgroup.isPresent()) {
			QueueAgentGroup deleteFound = queueagentgroup.get();
			deleteFound.setDelationOrder(99);
			queueagentRepository.save(deleteFound);
			agentService.getAllAgent();
			return new ResponseEntity<String>("The Agent Group has been successfully deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("The Agent Group not be deleted because it was not found !",HttpStatus.NOT_FOUND);
		}
	}

}
