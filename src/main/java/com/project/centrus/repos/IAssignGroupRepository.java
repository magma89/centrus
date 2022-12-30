package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.entities.AssignGroup;

public interface IAssignGroupRepository extends JpaRepository<AssignGroup, Long> {
	
	@Query(nativeQuery=true, value="SELECT AG.QAGID, Q.NAME,AQ.DESCRIPTION,AG.DISPATCH_ORDER FROM QUEUE_AGENT_GROUP AG\r\n"
			+ "INNER JOIN QUEUE Q ON Q.QID=AG.QID\r\n"
			+ "INNER JOIN AGENT_GROUP AQ ON AQ.AGID=AG.AGID\r\n"
			+ "WHERE AG.DELETION_ORDER = 0")
	 public List<AssignGroup> getAgentGroupAssign();

}
