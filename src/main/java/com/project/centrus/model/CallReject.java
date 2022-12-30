package com.project.centrus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class CallReject {

	@Id
	@Column(name="ID")
	Long id;
	
	@Column(name="CALL_REJECTION_RIGHT")
	Integer callReject;
}
