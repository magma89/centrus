package com.project.centrus.repos;
 

import org.springframework.data.jpa.repository.JpaRepository; 

import com.project.centrus.entities.GroupMembers; 

public interface IGroupMembersRepository extends JpaRepository<GroupMembers, Long> {
	
 
}
