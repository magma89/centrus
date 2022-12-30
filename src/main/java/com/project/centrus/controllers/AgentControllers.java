package com.project.centrus.controllers;
 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.centrus.entities.Agent;
import com.project.centrus.model.AgentFilter;
//import com.project.centrus.entities.Seat;
import com.project.centrus.model.AgentNames;
import com.project.centrus.model.Supervisor;
import com.project.centrus.model.SupervisorNames;
import com.project.centrus.services.AgentServices;

import lombok.extern.slf4j.Slf4j;
//import com.project.centrus.services.SeatServices;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/agent")
public class AgentControllers {

	private AgentServices agentServices;
	//SeatServices seatServices;
	 

	public AgentControllers(AgentServices agentServices /*,SeatServices seatServices*/) { 
		this.agentServices = agentServices;
		//this.seatServices = seatServices;
		 
	}
	
//	@GetMapping
//	public List<AgentFilter> getallFilterAgent(){
//		return agentServices.getAllFilteredAgent(); 
//	}
//	
	@GetMapping("/p")
	public Page<AgentFilter> getallFilteredAgent(Pageable pageable){
		return agentServices.getAllFilteredAgent(pageable); 
	}
	
	@GetMapping("/supervisor")
	public List<Agent> getAllSupervisor(){
		return agentServices.getSupervisor(); 
	}
	
 	
	@GetMapping("/supervisornames")
	public List<SupervisorNames> getSupervisorNames(){
		return agentServices.getsupervisorNames();
	}
	
	@GetMapping("/supervisor/{queueid}")
	public List<Supervisor> getSupervisorQueueId(@PathVariable Long queueid){ 
		return agentServices.getSupervisorQueueId(queueid);
	}
	
	
	@GetMapping("/names")
	public List<AgentNames> getAgentNames(){
		return agentServices.getagentNames();
	}
	
//	@PostMapping("/add")
//	public ResponseEntity<String> createAgent (@RequestBody Agent newAgent){
//		//String seatDescription = newAgent.getNAME();
//		//String seatIP = newAgent.getNewp();
//		//seatServices.createSeat(seatDescription,seatIP);
//		return agentServices.createAgent(newAgent);
//	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Object> createAgent(@RequestBody Agent newAgent){
		try {
			return agentServices.createAgent("Success",HttpStatus.OK,newAgent);
		} catch(Exception e) {
			return agentServices.createAgent(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
	}
	
	@PutMapping("/update/{aid}")
	public ResponseEntity<String> updateAgent(@PathVariable Long aid, @RequestBody Agent updateAgent){ 
		log.info("Agent Gelen İstek " + updateAgent);
		return agentServices.updateAgent(aid,updateAgent);
	}
	
 
	
	@PutMapping("/delete/{aid}")
	public ResponseEntity<String> deleteAgent(@PathVariable Long aid){ 
		//seatServices.deleteSeat(aid);
		return agentServices.deleteAgent(aid);
		
	}
}
