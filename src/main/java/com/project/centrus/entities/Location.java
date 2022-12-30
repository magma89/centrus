package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="LOCATION")
public class Location {
	
	@Id
	@Column(name="LOCATION_ID")
	Long locationId;
	
	@Column(name="DESCRIPTION")
	String description;

}
