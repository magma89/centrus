package com.project.centrus.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.project.centrus.entities.Queue;
import com.project.centrus.model.QueueNames;
import com.project.centrus.services.QueueServices;

@CrossOrigin
@RestController
@RequestMapping("/queue")
public class QueueControllers {
	
	private QueueServices queueServices; 
	
	public QueueControllers(QueueServices queueServices) {
		this.queueServices = queueServices;
	}
	

	
//	@GetMapping
//	public List<Queue> getAllQueue(){
//		return queueServices.getallQueue();
//	}
	
	@GetMapping("/p")
	public Page<Queue> pagination(Pageable pageable){
		return queueServices.getallQueue(pageable);
	}
	
	@GetMapping("/p/passive")
	public Page<Queue> paginationPassive(Pageable pageable){
		return queueServices.getallPassiveQueue(pageable);
	}
	
	@GetMapping("/names")
	public List<QueueNames> getQueueNames(){ 
		return queueServices.getQueueNames();
		
	}
		 
	 
//	@PostMapping("/add")
//	public ResponseEntity<String> createQueue(@RequestBody Queue newQueue) {
//		return queueServices.createQueue(newQueue);
//		
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> createQueue(@RequestBody Queue newQueue){
		return queueServices.createQueue("Success",HttpStatus.OK,newQueue);
	}
	
	@PutMapping("/update/{queueid}")
	public ResponseEntity<String> updateQueue(@PathVariable Long queueid, @RequestBody Queue updateQueue){
		return queueServices.updateQueue(queueid, updateQueue);
	}
	
	@DeleteMapping("/delete/{queueid}")
	public ResponseEntity<String> deleteQueue(@PathVariable Long queueid){
		return queueServices.deleteQueue(queueid);
	
	}

}
