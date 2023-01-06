package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="QUEUE_AGENT_GROUP")
@Data
public class QueueAgentGroup {
	@Id
	@Column(name="QAGID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long qagid;
	
	@Column(name="QID")
	Integer qid;
	@Column(name="AGID")
	Integer agid;
	@Column(name="DISPATCH_ORDER")
	Integer dispatchOrder;
	@Column(name="DELETION_ORDER")
	Integer delationOrder;

}
