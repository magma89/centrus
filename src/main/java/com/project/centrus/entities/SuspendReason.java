package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SUSPEND_REASON")
@Data
public class SuspendReason {

		@Id
		@Column(name="SUSPENDID") 
		Long suspendid;
		
		@Column(name="LIST_ORDER")
		Integer listOrder;
		
		@Column(name="SUSPEND_DESCRIPTION")
		String suspendDescription;
		
		@Column(name="ICON_ID")
		Integer iconId;
}
