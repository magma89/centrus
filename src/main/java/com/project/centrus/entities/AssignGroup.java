package com.project.centrus.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AssignGroup {
	@Id
	
	Long QAGID;
	String NAME;
	String DESCRIPTION;
	Integer DISPATCH_ORDER;

}
