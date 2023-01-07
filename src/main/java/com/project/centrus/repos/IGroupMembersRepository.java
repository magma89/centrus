package com.project.centrus.repos;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.centrus.entities.GroupMembers;
import com.project.centrus.model.Members; 

public interface IGroupMembersRepository extends JpaRepository<GroupMembers, Long> {
	
 
}
