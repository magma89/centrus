package com.project.centrus.entities;
 

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="QUEUE_SUPERVISOR")
@Data
public class QueueSupervisor {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer ID; 
	
	Long QID; 
	Integer AID;
	
 
}
