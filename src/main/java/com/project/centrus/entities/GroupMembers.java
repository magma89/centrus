package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="GROUP_MEMBERS")
@Data
public class GroupMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GMID")
	Long gmid;
	 
	@Column(name="AID")
	Long aid; 
	
	@Column(name="AGID")
	Long agid; 
	
	@Column(name="DELETION_ORDER")
	Integer deletionOrder = 0;
	
}
