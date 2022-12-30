package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="QUEUE")
@Data
public class Queue {

	@Id
	@Column(name="QID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long QID;
	 
	String EXT; 
	String NAME; 
	byte STATUS; 
	String Q_TYPE;
	byte PLAY_POSITION; 
	int MAX_WAIT_TIME; 
	byte PLAY_WAIT_TIME_EXPECTED;
	String MUSIC_ON_QUEUE_FILE;
	String MUSIC_ON_HOLD_FILE;
	int WRAPUP_TIME;
	byte CALL_TIMEOUT;
	byte RECORD_FLAG;
	int DELETION_ORDER;
	String SRV_PROV_CODE;
	String REDIR_CLOSED;
	String REDIR_MAX_SIZE;
	String REDIR_MAX_WAIT;
	String REDIR_NO_AGENT;
	int ACTION_CLOSED;
	int ACTION_MAX_SIZE;
	int ACTION_MAX_WAIT;
	int ACTION_NO_AGENT;
	int SERVICE_LEVEL_THRESHOLD;
	String DIRECTION;
	Integer OUTDIAL_STATUS;
	Integer OUTDIAL_SCHEDULE;
	String OUTBOUND_CLI;
	String DESCRIPTION;
	Integer ERD_STATUS;
	Integer CALLBACK_ENABLED;
	String SUBJECT;
	String EMAIL;
	Integer MAX_SIZE;
	Integer PRIORITY;
	Integer CALLBACK_ENABLE_TIME;
	Integer SCOREBOARD_STATS; 
	String SHORT_DESCRIPTION;
}
