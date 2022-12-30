package com.project.centrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CHARGING_SYSTEM_SETTINGS")
public class ChargingSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	Long id;
	
	@Column(name="CLIENT1_HOST_IP")
	String client1HostIp;
	
	@Column(name="CLIENT1_HOST_PORT")
	Integer client1HostPort;
	
	@Column(name="CLIENT1_REALM")
	String client1Realm;
	
	@Column(name="CLIENT2_HOST_IP")
	String client2HostIp;
	
	@Column(name="CLIENT2_HOST_PORT")
	Integer client2HostPort;
	
	@Column(name="CLIENT2_REALM")
	String client2Realm;
	
	@Column(name="SNMP_IP")
	String snmpIp;
	
	@Column(name="SNMP_PORT")
	Integer snmpPort;
	
	@Column(name="REQUEST_TIMEOUT")
	Integer requestTimeout;
	
	@Column(name="PRIMARY_HOST_PREPAID_IP")
	String primaryHostPrepaidIp;
	
	@Column(name="PRIMARY_HOST_PREPAID_PORT")
	Integer primaryHostPrepaidPort;
	
	@Column(name="PRIMARY_REALM_PREPAID")
	String primaryRealmPrepaid;
	
	@Column(name="SECONDARY_HOST_PREPAID_IP")
	String secondaryHostPrepaidIp;
	
	@Column(name="SECONDARY_HOST_PREPAID_PORT")
	Integer secondaryHostPrepaidPort;
	
	@Column(name="SECONDARY_REALM_PREPAID")
	String secondaryRealmPrepaid;
	
	@Column(name="PRIMARY_HOST_POSTPAID_IP")
	String primaryHostPostpaidIp;
	
	@Column(name="PRIMARY_HOST_POSTPAID_PORT")
	Integer primaryHostPostpaidPort;
	
	@Column(name="PRIMARY_REALM_POSTPAID")
	String primaryRealmPostpaid;
	
	@Column(name="SECONDARY_HOST_POSTPAID_IP")
	String secondaryHostPostpaidIp;
	
	@Column(name="SECONDARY_HOST_POSTPAID_PORT")
	Integer secondaryHostPostpaidPort;
	
	@Column(name="SECONDARY_REALM_POSTPAID")
	String secondaryRealmPostpaid;
	
	@Column(name="TRAFFIC_CASE_PREPAID")
	Integer trafficCasePrepaid;
	
	@Column(name="TRAFFIC_CASE_POSTPAID")
	Integer trafficCasePostpaid;
	
	
	
	
}
