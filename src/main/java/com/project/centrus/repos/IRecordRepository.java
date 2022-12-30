package com.project.centrus.repos;

 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.Records;

public interface IRecordRepository extends JpaRepository<Records, Long> {
	
	@Query(nativeQuery=true, value="SELECT * FROM vw_RECORDING WHERE STARTTIME > CONVERT(VARCHAR, GETDATE(), 23) + ' 00:00:000'") 
	public List<Records> getCurrentRecord();
	
//	@Query(nativeQuery=true,value="SELECT * FROM vw_RECORDING WHERE (AGENTNAME=:agentname OR :agentname='-1') "
//			+ "AND ((STARTTIME > :startime AND STARTTIME < CONVERT(VARCHAR,DATEADD(DAY,+1,:startime),23))  OR :startime='-1') "
//			+ "AND (QUEUENAME=:queuename OR :queuename='-1') AND (DURATION_IN_SECONDS=:duration OR :duration='-1') "
//			+ "AND (MSISDN=:msisdn OR :msisdn='-1') ")
//	public Page<Records> getFilteredRecord(@Param("agentname") String agentname,@Param("startime") String startime,@Param("queuename") String queuename,
//											@Param("duration") String duration,@Param("msisdn") String msisdn, Pageable pageable);
	
	@Query(nativeQuery = true,value="EXEC sp_RECORDING_FILTERED :startTime,:endTime,:operator,:queue,:msisdn,:durationInSec,:durationParam,:durationType")
	public List<Records> getFilteredRecord(@RequestParam String startTime,@RequestParam String endTime,@RequestParam String operator,@RequestParam String queue,@RequestParam String msisdn,
			@RequestParam String durationInSec,@RequestParam int durationParam,@RequestParam String durationType);

}
