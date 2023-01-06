package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.entities.AgentGroup;
import com.project.centrus.model.AgentGroupNames;

public interface IAgentGroupRepository extends JpaRepository<AgentGroup, Long> {
	
	@Query(nativeQuery=true, value="SELECT * FROM AGENT_GROUP WHERE DELETION_ORDER=0")
	public List<AgentGroup> getAllGroupAgent();
	
	@Query(nativeQuery=true, value="SELECT DESCRIPTION FROM AGENT_GROUP WHERE DELETION_ORDER=0")
	public List<AgentGroupNames> getAllGroupAgentNames();
	

	
}
