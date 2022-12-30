package com.project.centrus.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.model.AgentFilter;

public interface IAgentFilterRepository extends JpaRepository<AgentFilter, Long> {
	
	@Query(nativeQuery=true, value="\r\n"
			+ " SELECT Agent.AID AS aid,Agent.NAME AS NAME,Agent.USERNAME AS USERNAME ,Agent.ROLE AS ROLE ,Agent.EXT AS EXT ,Agent.EMAIL AS EMAIL,Agent.LANGUAGE_ID AS LANGUAGE_ID ,Agent.MAX_FAIL_BEFORE_SUSPEND AS MAX_FAIL_BEFORE_SUSPEND\r\n"
			+ " ,Agent.HOME AS HOME,Agent.GSM AS GSM,Agent.CALL_TRANSFER AS CALL_TRANSFER,Agent.DOWNLOAD_ENABLED AS DOWNLOAD_ENABLED,SEATS.SEAT_ID as SEAT_ID,SEATS.IP AS SEAT_IP\r\n"
			+ " FROM Agent INNER JOIN SEATS ON Agent.AID=SEATS.AID where Agent.deletion_order=0",		
			countQuery="SELECT COUNT(*) FROM Agent  INNER JOIN SEATS ON Agent.AID=SEATS.AID where Agent.deletion_order=0"
			)
	public Page<AgentFilter> getallFilterAgent(Pageable pageable);

}
