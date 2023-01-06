package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.model.WarnQueueNames;

public interface IWarnQueueNamesRepository extends JpaRepository<WarnQueueNames, Long> {
	
	@Query(nativeQuery=true,value="SELECT ID,WS.QID,MAX_WAIT_CALL,MAX_STANDBY_AGENTS,MIN_AR,Q.NAME FROM WARN_SETTINGS WS\r\n"
			+ "INNER JOIN QUEUE Q ON Q.QID=WS.QID")
	public List<WarnQueueNames> getWarnSettings();

}
