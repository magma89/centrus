package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.centrus.entities.Agent;

public interface IAgentRepository extends JpaRepository<Agent, Long> {
	
	
	
	@Query(nativeQuery=true, value="SELECT * FROM AGENT WHERE DELETION_ORDER=0")
	public List<Agent> getallAgent();
	
	//Agent getfilteredAgent(@Param("id") Long id);
	
	@Query(nativeQuery=true, value="SELECT * FROM AGENT WHERE ROLE=2 AND DELETION_ORDER=0")
	public List<Agent> getsupervisor();
	

	
	@Query(value="FROM Agent A INNER JOIN QueueSupervisor Q ON Q.AID = A.AID "
			+ "WHERE Q.QID = :qid")  
//	@Query(nativeQuery=true, value = "SELECT * FROM Agent A INNER JOIN QUEUE_SUPERVISOR Q ON Q.AID = A.AID WHERE Q.QID = :qid")
//	@Query(value = "SELECT new com.project.centrus.entities.Agent(A.NAME,Q.AID) FROM Agent A INNER JOIN QueueSupervisor Q ON q= A.AID WHERE Q.QID = :qid")
	List<Agent> getfilteredSupervisor(@Param("qid") Long serviceId);
	
	

}
