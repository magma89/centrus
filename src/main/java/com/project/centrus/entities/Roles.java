package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ROLES")
public class Roles {
	@Id
	@Column(name="ID")
	Integer id;
	
	@Column(name="ROLE_ID")
	Integer roleId;
	
	@Column(name="DESCRIPTION")
	String description;
}
