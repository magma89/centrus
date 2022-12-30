package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.centrus.entities.Queue;

public interface IQueueRepository extends JpaRepository<Queue, Long> {
	
	@Query(nativeQuery=true, value="SELECT * FROM QUEUE where deletion_order=0")
	public List<Queue> getallQueueNames();
	
	@Query(nativeQuery=true, value="SELECT * FROM QUEUE where deletion_order=0 and status=0")
	public Page<Queue> getallPassiveQueue(Pageable pageable);
	
	@Query(nativeQuery=true, value="SELECT * FROM QUEUE where deletion_order=0 and status=1")
	public Page<Queue> getallQueue(Pageable pageable);
}
