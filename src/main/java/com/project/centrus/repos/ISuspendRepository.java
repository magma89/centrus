package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.entities.SuspendReason;

public interface ISuspendRepository extends JpaRepository<SuspendReason, Long> {
	
	@Query(nativeQuery=true,value="SELECT TOP 1 LIST_ORDER FROM SUSPEND_REASON ORDER BY LIST_ORDER DESC")
	public int getListOrder();

}
