package com.project.centrus.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.services.AssignGroupQueueServices;

@CrossOrigin
@RestController
@RequestMapping("/queueagent")
public class QueueAgentControllers {
	
	private AssignGroupQueueServices queueAgentgroupServices;

	public QueueAgentControllers(AssignGroupQueueServices queueAgentgroupServices) { 
		this.queueAgentgroupServices = queueAgentgroupServices;
	}
	
//	@PutMapping("/delete/qagid={qagid}&queueid={queueid}&agid={agid}&dispatch={dispatch}")
//	public ResponseEntity<String> deleteQeueAgentGroup(@PathVariable ("qagid") Long qagid,@PathVariable ("queueid") Long queueid, @PathVariable ("agid") Integer agid,@PathVariable ("dispatch") Integer dispatch){
//		return queueAgentgroupServices.deleteQueueAgentGroup(qagid,queueid,agid,dispatch);
//	}
	
	@PutMapping("/delete/{qagid}")
	public ResponseEntity<String> deleteQeueAgentGroup(@PathVariable ("qagid") Long qagid){
		return queueAgentgroupServices.deleteQueueAgentGroup(qagid);
	}

}
