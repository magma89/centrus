package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="WARN_EMAIL_LIST")
@Data
public class WarnEmail {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	@Column(name="TYPE")
	Integer type;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="DELETION_ORDER")
	Integer deletionOrder;
	
	
}
