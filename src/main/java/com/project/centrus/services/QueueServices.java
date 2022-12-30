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

import com.project.centrus.entities.Queue;
import com.project.centrus.model.QueueNames;
import com.project.centrus.repos.IQueueRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QueueServices {
	
	IQueueRepository queueRepository;

	public QueueServices(IQueueRepository queueRepository) { 
		this.queueRepository = queueRepository;
	}

//	public List<Queue> getallQueue() { 
//		return queueRepository.getallQueue();
//	}
	
	public Page<Queue> getallQueue(Pageable pageable){
		return queueRepository.getallQueue(pageable);
	}
	
	public Page<Queue> getallPassiveQueue(Pageable pageable){
		return queueRepository.getallPassiveQueue(pageable);
	}
	
	public List<QueueNames> getQueueNames(){
		List<QueueNames> names = new ArrayList<>(); 
		List<Queue> qnames = queueRepository.getallQueueNames(); 
	 
		for (Queue tempname : qnames) { 
			names.add(new QueueNames(tempname.getQID(), tempname.getNAME()));
		}
		return names;
	}
	
//	public ResponseEntity<String> createQueue(@RequestBody Queue newQueue) {
//		@SuppressWarnings("unused")
//		List<String> ifexistQueue = new ArrayList<>();
//		Optional<Queue> queue = queueRepository.findById(newQueue.getQID());
//		if (queue.isPresent()) {
//			return new ResponseEntity<>("This queue id already exists. !",HttpStatus.INTERNAL_SERVER_ERROR);
//		}else {
//			queueRepository.save(newQueue);
//			return new ResponseEntity<String>("The queue has been successfuly added. ! ",HttpStatus.OK);
//		}
//		
//	}
	
	public ResponseEntity<Object> createQueue(String message,HttpStatus status,@RequestBody Queue newQueue){
		queueRepository.save(newQueue);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("queueid", newQueue.getQID());
		return new ResponseEntity<Object>(map,status);
	}
	
	public ResponseEntity<String> updateQueue(@PathVariable Long queueid, @RequestBody Queue updateQueue){
		log.info(queueid.toString());
		Optional<Queue> queue = queueRepository.findById(queueid);
		log.info(queueid.toString());
		if(queue.isPresent()) {
			Queue foundQueue = queue.get();
//			log.info(foundQueue.getQID().toString());
//			foundQueue.setACTION_CLOSED(updateQueue.getACTION_CLOSED());
//			foundQueue.setACTION_MAX_SIZE(updateQueue.getACTION_MAX_SIZE());
//			foundQueue.setACTION_MAX_WAIT(updateQueue.getACTION_MAX_WAIT());
//			foundQueue.setACTION_NO_AGENT(updateQueue.getACTION_NO_AGENT());
//			foundQueue.setCALL_TIMEOUT(updateQueue.getCALL_TIMEOUT());
//			foundQueue.setCALLBACK_ENABLE_TIME(updateQueue.getCALLBACK_ENABLE_TIME());
//			foundQueue.setCALLBACK_ENABLED(updateQueue.getCALLBACK_ENABLED());
//			foundQueue.setDELETION_ORDER(updateQueue.getDELETION_ORDER());
//			foundQueue.setDESCRIPTION(updateQueue.getDESCRIPTION());
//			foundQueue.setDIRECTION(updateQueue.getDIRECTION());
//			foundQueue.setEMAIL(updateQueue.getEMAIL());
//			foundQueue.setERD_STATUS(updateQueue.getERD_STATUS());
//			foundQueue.setEXT(updateQueue.getEXT());
//			foundQueue.setMAX_SIZE(updateQueue.getACTION_MAX_SIZE());
//			foundQueue.setMAX_WAIT_TIME(updateQueue.getMAX_WAIT_TIME());
//			foundQueue.setMUSIC_ON_HOLD_FILE(updateQueue.getMUSIC_ON_HOLD_FILE());
//			foundQueue.setMUSIC_ON_QUEUE_FILE(updateQueue.getMUSIC_ON_QUEUE_FILE());
//			foundQueue.setNAME(updateQueue.getNAME());
//			foundQueue.setOUTBOUND_CLI(updateQueue.getOUTBOUND_CLI());
//			foundQueue.setOUTDIAL_SCHEDULE(updateQueue.getOUTDIAL_SCHEDULE());
//			foundQueue.setOUTDIAL_STATUS(updateQueue.getOUTDIAL_STATUS());
//			foundQueue.setPLAY_POSITION(updateQueue.getPLAY_POSITION());
//			foundQueue.setPLAY_WAIT_TIME_EXPECTED(updateQueue.getPLAY_WAIT_TIME_EXPECTED());
//			foundQueue.setPRIORITY(updateQueue.getPRIORITY());
//			foundQueue.setQ_TYPE(updateQueue.getQ_TYPE());
//			foundQueue.setRECORD_FLAG(updateQueue.getRECORD_FLAG());
//			foundQueue.setREDIR_CLOSED(updateQueue.getREDIR_CLOSED());
//			foundQueue.setREDIR_MAX_SIZE(updateQueue.getREDIR_MAX_SIZE());
//			foundQueue.setREDIR_MAX_WAIT(updateQueue.getREDIR_MAX_WAIT());
//			foundQueue.setREDIR_NO_AGENT(updateQueue.getREDIR_NO_AGENT());
//			foundQueue.setSCOREBOARD_STATS(updateQueue.getSCOREBOARD_STATS());
//			foundQueue.setSERVICE_LEVEL_THRESHOLD(updateQueue.getSERVICE_LEVEL_THRESHOLD());
//			foundQueue.setSHORT_DESCRIPTION(updateQueue.getSHORT_DESCRIPTION());
//			foundQueue.setSRV_PROV_CODE(updateQueue.getSRV_PROV_CODE());
//			foundQueue.setSTATUS(updateQueue.getSTATUS());
//			foundQueue.setSUBJECT(updateQueue.getSUBJECT());
//			foundQueue.setWRAPUP_TIME(updateQueue.getWRAPUP_TIME());
//			queueRepository.save(foundQueue);
			queueRepository.save(foundQueue);
			return new ResponseEntity<String>("The queue has been successfully updated.",HttpStatus.OK);		
		}else {
			return new ResponseEntity<String>("Queue Not Found ! ",HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<String> deleteQueue(@PathVariable Long queueid){
		Optional<Queue> queue = queueRepository.findById(queueid);
		if(queue.isPresent()) {
			Queue deleteFound = queue.get();
			deleteFound.setDELETION_ORDER(99);
			queueRepository.save(deleteFound);
			return new ResponseEntity<String>("The queue has been successfully deleted .",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("The queue could not be deleted because it was not found !",HttpStatus.NOT_FOUND);
		}
	
	}

}
