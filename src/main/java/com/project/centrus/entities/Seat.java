package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SEATS")
@Data
public class Seat {
	
	@Id
	@Column(name="SEAT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long seatId;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="IP")
	String ip;
	
	@Column(name="TEL_NO")
	String telNo;
	
	@Column(name="DELETION_ORDER")
	Integer deletionOrder;
	
	@Column(name="AID")
	Integer aid;
	
}
