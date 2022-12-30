package com.project.centrus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.centrus.entities.Agent;
import com.project.centrus.entities.Seat;
import com.project.centrus.model.AgentFilter;
import com.project.centrus.model.AgentNames;
import com.project.centrus.model.Supervisor;
import com.project.centrus.model.SupervisorNames;
import com.project.centrus.repos.IAgentFilterRepository;
import com.project.centrus.repos.IAgentRepository;
import com.project.centrus.repos.ISeatRepository;

 
//import lombok.extern.slf4j.Slf4j;
 

//@Slf4j
@Service
public class AgentServices {
	
	IAgentRepository agentRepository;
	ISeatRepository seatRepository;
	IAgentFilterRepository agentFilterRepository;

	public AgentServices(IAgentRepository agentRepository, ISeatRepository seatRepository,IAgentFilterRepository agentFilterRepository) { 
		this.agentRepository = agentRepository;
		this.seatRepository = seatRepository;
		this.agentFilterRepository=agentFilterRepository;
	}

	public Page<AgentFilter> getAllFilteredAgent(Pageable pageable) {
		//List<Agent> list = agentRepository.getallAgent(); 
		//return list;
		return agentFilterRepository.getallFilterAgent(pageable);
	}
	
	public List<Agent> getAllAgent(){
		return agentRepository.getallAgent();
	}
	
	public List<Agent> getSupervisor() {
		return agentRepository.getsupervisor();
	}
	
	public List<SupervisorNames> getsupervisorNames() {
	List<SupervisorNames> supervisornames = new ArrayList<>();
	List<Agent> spnames = agentRepository.getsupervisor();
	for (Agent tempspName : spnames) {
		supervisornames.add(new SupervisorNames (tempspName.getAID(),tempspName.getNAME()));
	}
	return supervisornames;
	}
	
	
	public List<AgentNames> getagentNames() {
		List<AgentNames> agentnames = new ArrayList<>();
		List<Agent> agnames = agentRepository.getallAgent();
		for (Agent tempspName : agnames) {
			agentnames.add(new AgentNames(tempspName.getAID(), tempspName.getNAME()));
		}
		return agentnames;
	}
	
	public List<Supervisor> getSupervisorQueueId(@PathVariable Long queueid){
		List<Supervisor> supervisornames = new ArrayList<>();
		List<Agent> names = agentRepository.getfilteredSupervisor(queueid);
		for(Agent tempNames : names) {
			supervisornames.add(new Supervisor(tempNames.getAID()));
		}
		return supervisornames;
	}
	
	
 

//	public ResponseEntity<String> createAgent(@RequestBody Agent newAgent){
//		agentRepository.save(newAgent);
////		Seat newSeat = new Seat();
////		newSeat.setDESCRIPTION(newAgent.getNAME());
////		log.info(newSeat.getDESCRIPTION());
////		newSeat.setIP(newAgent.getNewp());
////		newSeat.setTEL_NO(newAgent.getNewp());
////		newSeat.setDELETION_ORDER(0);
////		seatRepository.save(newSeat);
//		return new ResponseEntity<String>("Agent successfuly added. ! ",HttpStatus.OK);
//	}
	
	
//	public ResponseEntity<String> createAgent(@RequestBody Agent newAgent){
//	agentRepository.save(newAgent);
//	return new ResponseEntity<String>("{\"Result\": \"Agent Successfully Added.\"}",HttpStatus.OK);
// 
//}
	
	
	public ResponseEntity<Object> createAgent(String message, HttpStatus status,@RequestBody Agent newAgent){	 
		agentRepository.save(newAgent);
		Seat newSeat = new Seat();
		newSeat.setDescription(newAgent.getNAME());
		newSeat.setIp(newAgent.getNewp());
		newSeat.setTelNo(newAgent.getNewp());
		newSeat.setDeletionOrder(0);
		seatRepository.save(newSeat);
		 Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("aid", newAgent.getAID());
         return new ResponseEntity<Object>(map,status);
		 
	}
	
	public ResponseEntity<String> updateAgent(@PathVariable Long aid, @RequestBody Agent updateAgent){
		Optional<Agent> agent = agentRepository.findById(aid);
		if(agent.isPresent()) {
			Agent foundAgent = agent.get(); 
			foundAgent.setNAME(updateAgent.getNAME());
			foundAgent.setADSOYAD(updateAgent.getNAME()); 
			foundAgent.setUSERNAME(updateAgent.getUSERNAME());
			foundAgent.setPASSWORD(updateAgent.getPASSWORD());
			foundAgent.setEXT(updateAgent.getEXT());
			foundAgent.setROLE(updateAgent.getROLE());
			foundAgent.setUSER_TYPE(updateAgent.getUSER_TYPE());
			foundAgent.setLANGUAGE_ID(updateAgent.getLANGUAGE_ID());
			foundAgent.setMAX_FAIL_BEFORE_SUSPEND(updateAgent.getMAX_FAIL_BEFORE_SUSPEND());
			foundAgent.setHOME(updateAgent.getHOME());
			foundAgent.setGSM(updateAgent.getGSM());
			foundAgent.setDELETION_ORDER(updateAgent.getDELETION_ORDER());
			foundAgent.setSRV_PROV_CODE(updateAgent.getSRV_PROV_CODE());
			foundAgent.setCALL_TRANSFER(updateAgent.getCALL_TRANSFER());
			foundAgent.setEMAIL(updateAgent.getEMAIL());
			foundAgent.setOUTBOUND_CLI(updateAgent.getOUTBOUND_CLI());
			foundAgent.setSTATUS(updateAgent.getSTATUS());
			foundAgent.setIS_WEB_AGENT(updateAgent.getIS_WEB_AGENT());
			foundAgent.setINTRO_STATUS(updateAgent.getINTRO_STATUS());
			foundAgent.setPROFILE(updateAgent.getPROFILE());
			foundAgent.setAPPROVAL(updateAgent.getAPPROVAL());
			foundAgent.setADSOYAD(updateAgent.getADSOYAD());
			foundAgent.setCRM_STATUS(updateAgent.getCRM_STATUS());
			foundAgent.setWORK_TIME(updateAgent.getWORK_TIME());
			foundAgent.setDOWNLOAD_ENABLED(updateAgent.getDOWNLOAD_ENABLED());
			agentRepository.save(foundAgent);
			
					
			/*
			Optional<Agent> agent2 = agentRepository.findById(aid);
			System.out.println(agent2.get().getNAME());
			System.out.println(agent2.get().getNAME());
			System.out.println(agent2.get().getNAME());
			System.out.println(agent2.get().getNAME());
			System.out.println(agent2.get().getNAME());
			*/
//			Optional<Agent> agentSeat = agentRepository.findById(aid);
//			String description = agentSeat.get().getNAME();
//			log.info("Get Name " + description);
//			List<Seat> seat = seatRepository.getSeatByDescription(description); 
////			((Seat) seat).setDESCRIPTION(foundAgent.getNAME());
////			log.info(seat.toString());
////			seat.setIP(foundAgent.getNewp());
////			seat.setTEL_NO(foundAgent.getNewp());
////			seatRepository.save(seat);


			return new ResponseEntity<String>(" Agent successfully updated. ",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(" Agent not found !",HttpStatus.NOT_FOUND);
		}
	}
		
		public ResponseEntity<String> deleteAgent(@PathVariable Long aid){
			Optional<Agent> agent = agentRepository.findById(aid);
			if(agent.isPresent()) {
				Agent foundAgent = agent.get();
				foundAgent.setDELETION_ORDER(99);
				agentRepository.save(foundAgent);
				return new ResponseEntity<String>(" Agent is deleted !",HttpStatus.OK);
			}else {
				return new ResponseEntity<String> (	"Agent Not Found..",HttpStatus.NOT_FOUND);
			}
		}

}
